package com.min.hillclimbing.solution;

import static java.lang.Math.pow;

public class BinaryToDoubleTranslator {

    public double[] translate(int[][] binaryArray) {
        double[] translation = new double[binaryArray.length];
        for (int j = 0; j < binaryArray.length; j++) {
            double sum = 0;
            int[] element = binaryArray[j];
            for (int i = 0; i < element.length - 1; i++) {
                sum = sum + pow((element.length - 1 - i), 2) * element[i];
            }
            translation[j] = sum;
        }
        return translation;
    }
}
