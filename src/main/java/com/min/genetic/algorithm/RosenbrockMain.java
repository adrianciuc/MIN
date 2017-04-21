package com.min.genetic.algorithm;

import com.min.hillclimbing.function.Rosenbrock;

public class RosenbrockMain {

    public static void main(String[] args) {
        GeneticAlgorithm algorithm = new GeneticAlgorithm(
                new Rosenbrock(-2.048, 2.048, 30),
                50,
                200,
                0.000001,
                0.1,
                0.4
        );
        for (int i = 0; i < 30; i++) {
            algorithm.run();
        }
    }
}