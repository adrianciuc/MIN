package com.min.hybrid;

import com.min.genetic.algorithm.GeneticAlgorithm;
import com.min.hillclimbing.function.Rastrigin;

import static java.util.stream.IntStream.range;

public class RastriginMain {

    public static void main(String[] args) {
        execute(0);
    }

    private static void execute(Integer i) {
        HybridAlgorithm algorithm = new HybridAlgorithm(
                new Rastrigin(-5.12, 5.12, 30),
                50,
                200,
                0.000001,
                0.1,
                0.4,
                0.3
        );
        algorithm.run();
    }
}
