package com.min.hillclimbing.function;

import static java.lang.Math.pow;

public class Shcb extends Function {

    private final double secondLowerBound;
    private final double secondUpperBound;

    public Shcb(double lowerBound, double upperBound, double secondLowerBound, double secondUpperBound, int numberOfElementsInSolution) {
        super(lowerBound, upperBound, numberOfElementsInSolution);
        this.secondLowerBound = secondLowerBound;
        this.secondUpperBound = secondUpperBound;
    }

    @Override
    public double evaluateFor(double[] candidateSolution) {
        double t1 = (4 - 2.1 * pow(candidateSolution[0], 2) + pow(candidateSolution[0], 4) / 3) * pow(candidateSolution[0], 2);
        double t2 = candidateSolution[0] * candidateSolution[1];
        double t3 = (-4 + 4 * pow(candidateSolution[1], 2)) * pow(candidateSolution[1], 2);
        return t1 + t2 + t3;
    }

    public double getSecondLowerBound() {
        return secondLowerBound;
    }

    public double getSecondUpperBound() {
        return secondUpperBound;
    }
}
