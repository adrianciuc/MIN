package com.min.genetic.algorithm;

import com.min.hillclimbing.function.Rastrigin;

public class RastriginMain {

    public static void main(String[] args) {
        GeneticAlgorithm algorithm = new GeneticAlgorithm(
                new Rastrigin(-5.12, 5.12, 30),
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
