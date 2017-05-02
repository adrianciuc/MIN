package com.min.attraction;

import com.min.hillclimbing.function.Function;

import static java.lang.Math.pow;

public class FunctionToEvaluate extends Function {

    FunctionToEvaluate(double lowerBound, double upperBound, int numberOfElementsInSolution) {
        super(lowerBound, upperBound, numberOfElementsInSolution);
    }

    @Override
    public double evaluateFor(double[] candidateSolution) {
        return pow(candidateSolution[0], 3) - 60 * pow(candidateSolution[0], 2) + 900 * candidateSolution[0] + 100;
    }
}
