package com.min.hillclimbing.function;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.pow;

class Rastrigin extends Function {

    Rastrigin(double lowerBound,
              double upperBound,
              int numberOfElementsInSolution,
              int sizeOfElementInSolution) {
        super(lowerBound, upperBound, numberOfElementsInSolution, sizeOfElementInSolution);
    }

    @Override
    public double evaluateFor(double[] candidateSolution) {
        double sum = 10 * candidateSolution.length;
        for (double element : candidateSolution) {
            sum = sum + (pow(element, 2) - 10 * cos(2 * PI * element));
        }
        return sum;
    }
}
