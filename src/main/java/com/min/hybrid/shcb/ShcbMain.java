package com.min.hybrid.shcb;

import com.min.hillclimbing.function.Shcb;

import static java.util.stream.IntStream.range;

public class ShcbMain {

    public static void main(String[] args) {
        range(0, 30).parallel().forEach(ShcbMain::execute);
    }

    private static void execute(Integer i) {
        ShcbHybridAlgorithm algorithm = new ShcbHybridAlgorithm(
                new Shcb(-3, 3, -2, 2, 1),
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
