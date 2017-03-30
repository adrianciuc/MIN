package com.min.hillclimbing.solution;

public class BinaryToDoubleTranslator {

    public double[] translate(int[][] binaryArray) {
        double[] translation = new double[binaryArray.length];
        for (int j = 0; j < binaryArray.length; j++) {
            int sum = 0;
            int[] element = binaryArray[j];
            for (int i = 0; i < element.length - 1; i++) {
                sum = sum + 2 ^ (element.length - 1 - i) * element[i];
            }
            translation[j] = sum;
        }
        return translation;
    }
}
