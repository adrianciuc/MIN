package com.min.pso;

import com.min.hillclimbing.function.Function;

import java.util.List;
import java.util.Random;

import static com.min.pso.Utils.copyOf;
import static java.util.Collections.min;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class PSO {

    private final Random random;
    private final RandomParticleGenerator generator;
    private final Function function;
    private final int populationSize;
    private final int iterations;
    private final double minSpeed;
    private final double maxSpeed;
    private final double maxW;
    private final double minW;
    private final double w2;
    private final double w3;

    public PSO(Function function, int populationSize, int iterations, double minSpeed, double maxSpeed,
               double maxW, double minW, double w2, double w3) {
        this.random = new Random();
        this.generator = new RandomParticleGenerator();
        this.populationSize = populationSize;
        this.iterations = iterations;
        this.function = function;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.maxW = maxW;
        this.minW = minW;
        this.w2 = w2;
        this.w3 = w3;
    }

    public Particle execute() {
        List<Particle> population = range(0, populationSize)
                .mapToObj(it -> generator.generate(function, minSpeed, maxSpeed))
                .collect(toList());
        Particle bestParticle = null;
        double w;
        for (int i = 0; i < iterations; i++) {
            for (Particle particle : population) {
                if (particle.getFitness() < particle.getBestFitness()) {
                    particle.setBestFitness(particle.getFitness());
                    particle.setBestPosition(copyOf(particle.getPosition()));
                }
            }
//            System.out.println(min(population, comparing(Particle::getBestFitness)).getBestFitness());
            if (bestParticle == null || min(population, comparing(Particle::getFitness)).getBestFitness() < bestParticle.getBestFitness()) {
                bestParticle = min(population, comparing(Particle::getBestFitness)).copy();
            }
            w = maxW - ((((double) i)/iterations) * (maxW - minW));
            for (Particle particle : population) {
                updateSpeedAndPosition(particle, bestParticle, function, w);
            }
            population.forEach(particle -> particle.setFitness(function.evaluateFor(particle.getPosition())));
        }
        return bestParticle;
    }

    private void updateSpeedAndPosition(Particle particle, Particle bestParticle, Function function, double w) {
        double[] newSpeed = new double[particle.getSpeed().length];
        double r1 = random.nextDouble();
        double r2 = random.nextDouble();
        for (int i = 0; i < particle.getSpeed().length; i++) {
            newSpeed[i] = w * particle.getSpeed()[i]
                    + r1 * w2 * (particle.getBestPosition()[i] - particle.getPosition()[i])
                    + r2 * w3 * (bestParticle.getPosition()[i] - particle.getPosition()[i]);
        }
        particle.setSpeed(newSpeed);
        double[] newPosition = new double[particle.getPosition().length];
        for (int i = 0; i < particle.getPosition().length; i++) {
            newPosition[i] = particle.getPosition()[i] + particle.getSpeed()[i];
            if (newPosition[i] > function.getUpperBound()) {
                newPosition[i] = function.getUpperBound();
            }
            if (newPosition[i] < function.getLowerBound()) {
                newPosition[i] = function.getLowerBound();
            }
        }
        particle.setPosition(newPosition);
    }
}
