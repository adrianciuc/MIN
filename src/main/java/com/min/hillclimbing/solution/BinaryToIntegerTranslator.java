package com.min.hillclimbing.solution;

import static java.lang.Math.pow;

public class BinaryToIntegerTranslator {

    public int[] translate(int[][] binaryArray) {
        int[] translation = new int[binaryArray.length];
        for (int j = 0; j < binaryArray.length; j++) {
            int sum = 0;
            int[] element = binaryArray[j];
            for (int i = 0; i < element.length - 1; i++) {
                sum = sum + (int)(pow((element.length - 1 - i), 2)) * element[i];
            }
            translation[j] = sum;
        }
        return translation;
    }
}
