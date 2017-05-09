package com.min.pso;

import static com.min.pso.Utils.copyOf;

public class Particle {

    private double[] position;
    private double[] speed;
    private double fitness;
    private double bestFitness;
    private double[] bestPosition;

    public Particle(int size) {
        position = new double[size];
        speed = new double[size];
        bestPosition = new double[size];
    }

    public double[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(double[] bestPosition) {
        this.bestPosition = bestPosition;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public double[] getSpeed() {
        return speed;
    }

    public void setSpeed(double[] speed) {
        this.speed = speed;
    }

    public Particle copy() {
        Particle particle = new Particle(this.position.length);
        particle.setFitness(this.fitness);
        particle.setBestFitness(this.bestFitness);
        particle.setPosition(copyOf(this.position));
        particle.setBestPosition(copyOf(this.bestPosition));
        particle.setSpeed(copyOf(this.speed));
        return particle;
    }
}
