package com.min.hybrid;

import com.min.hillclimbing.function.Griewangk;

import static java.util.stream.IntStream.range;

public class GriewangkMain {

    public static void main(String[] args) {
        range(0, 30).parallel().forEach(GriewangkMain::execute);
    }

    private static void execute(Integer i) {
        HybridAlgorithm algorithm = new HybridAlgorithm(
                new Griewangk(-600, 600, 5),
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
