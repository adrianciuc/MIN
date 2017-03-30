package com.min.hillclimbing.solution;

import static java.lang.StrictMath.log;

public class DoubleToIntervalTranslator {

    public double[] translate(double[] toBeTranslated, double lowerBound, double upperBound) {
        double[] translation = new double[toBeTranslated.length];
        for (int i = 0; i < toBeTranslated.length; i++) {
            int a = (int)((log((10 ^ 2) * (upperBound - lowerBound)) / log(2)));
            translation[i] = ((toBeTranslated[i] / ((2 ^ a) - 1)) * (upperBound - lowerBound)) + lowerBound;
        }
        return translation;
    }
}
