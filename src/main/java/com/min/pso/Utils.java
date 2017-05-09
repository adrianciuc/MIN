package com.min.pso;

public class Utils {

    public static double[] copyOf(double[] toCoppy) {
        double[] toReturn = new double[toCoppy.length];
        for (int i = 0; i < toCoppy.length; i++) {
            toReturn[i] = toCoppy[i];
        }
        return toCoppy;
    }
}
