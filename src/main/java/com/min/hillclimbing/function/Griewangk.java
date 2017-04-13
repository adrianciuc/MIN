package com.min.hillclimbing.function;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Griewangk extends Function {

    public Griewangk(double lowerBound, double upperBound, int numberOfElementsInSolution) {
        super(lowerBound, upperBound, numberOfElementsInSolution);
    }

    @Override
    public double evaluateFor(double[] candidateSolution) {
        double sum = 0;
        double prod = 1;
        for (int i = 0; i < candidateSolution.length; i++) {
            sum = sum + (pow(candidateSolution[i], 2) / 4000);
            prod = prod * cos(candidateSolution[i] / sqrt(i + 1));
        }
        return sum - prod + 1;
    }
}
