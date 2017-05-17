package com.min.hillclimbing.function;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class Rastrigin extends Function {

    public static Integer EVALUATION_COUNTER = 0;

    public Rastrigin(double lowerBound, double upperBound, int numberOfElementsInSolution) {
        super(lowerBound, upperBound, numberOfElementsInSolution);
    }

    @Override
    public double evaluateFor(double[] candidateSolution) {
        double sum = 10 * candidateSolution.length;
        for (double element : candidateSolution) {
            sum = sum + ((pow(element, 2) - (10 * cos(2 * PI * element))));
        }
        EVALUATION_COUNTER++;
        return sum;
    }
}
