package com.min.hillclimbing.solution;


import static com.google.common.math.DoubleMath.log2;
import static java.lang.Math.pow;

public class IntegerToDoubleIntervalTranslator {

    public double[] translate(int[] toBeTranslated, double lowerBound, double upperBound) {
        double[] translation = new double[toBeTranslated.length];
        for (int i = 0; i < toBeTranslated.length; i++) {
            int a = (int)(log2((pow(10,2)) * (upperBound - lowerBound)));
            translation[i] = ((toBeTranslated[i] / ((pow(2,a)) - 1)) * (upperBound - lowerBound)) + lowerBound;
        }
        return translation;
    }
}
