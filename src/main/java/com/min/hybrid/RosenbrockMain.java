package com.min.hybrid;

import com.min.hillclimbing.function.Rosenbrock;

import static java.util.stream.IntStream.range;

public class RosenbrockMain {

    public static void main(String[] args) {
        range(0, 30).parallel().forEach(RosenbrockMain::execute);
    }

    private static void execute(Integer i) {
        HybridAlgorithm algorithm = new HybridAlgorithm(
                new Rosenbrock(-2.048, 2.048, 10),
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
