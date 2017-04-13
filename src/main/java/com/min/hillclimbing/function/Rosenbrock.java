package com.min.hillclimbing.function;

import static java.lang.Math.pow;

public class Rosenbrock extends Function {

    public Rosenbrock(double lowerBound, double upperBound, int numberOfElementsInSolution) {
        super(lowerBound, upperBound, numberOfElementsInSolution);
    }

    @Override
    public double evaluateFor(double[] candidateSolution) {
        double sum = 0;
        for(int i = 0; i < candidateSolution.length - 1; i++) {
            sum = sum + (100 * pow(candidateSolution[i + 1] - pow(candidateSolution[i], 2), 2))
                    + pow((1 - candidateSolution[i]), 2);
        }
        return sum;
    }
}
