package com.min.genetic.algorithm.shcb;

import com.min.hillclimbing.function.Shcb;

public class ShcbMain {

    public static void main(String[] args) {
        ShcbGeneticAlgorithm algorithm = new ShcbGeneticAlgorithm(
                new Shcb(-3, 3, -2, 2, 1),
                50,
                200,
                0.000001,
                0.1,
                0.4
        );

            algorithm.run();

    }
}
