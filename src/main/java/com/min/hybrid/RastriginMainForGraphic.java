package com.min.hybrid;

import com.min.hillclimbing.function.Rastrigin;

public class RastriginMainForGraphic {

    public static void main(String[] args) {
        HybridAlgorithm algorithm = new HybridAlgorithm(
                new Rastrigin(-5.12, 5.12, 30),
                100,
                200,
                0.000001,
                0.1,
                0.4,
                0.3
        );
        algorithm.run();
    }
}
