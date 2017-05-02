package com.min;

public class Utils {

    public static int[][] coppy(int size, int sizeOfEachElement, int[][] a) {
        int[][] rep = new int[size][sizeOfEachElement];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < sizeOfEachElement; j++) {
                rep[i][j] = a[i][j];
            }
        }
        return rep;
    }
}
