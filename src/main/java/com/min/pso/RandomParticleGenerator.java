package com.min.pso;

import com.min.hillclimbing.function.Function;

import java.util.Random;

public class RandomParticleGenerator {

    public Particle generate(Function function, double minSpeed, double maxSpeed) {
        Particle particle = new Particle(function.getNumberOfElementsInSolution());
        Random random = new Random();
        for (int i = 0; i < function.getNumberOfElementsInSolution(); i++) {
            particle.getSpeed()[i] = minSpeed + (maxSpeed - minSpeed) * random.nextDouble();
            particle.getPosition()[i] = function.getLowerBound()
                    + (function.getUpperBound() - function.getLowerBound()) * random.nextDouble();
            particle.getBestPosition()[i] = particle.getPosition()[i];
            particle.setFitness(function.evaluateFor(particle.getPosition()));
            particle.setBestFitness(particle.getFitness());
        }
        return particle;
    }
}
