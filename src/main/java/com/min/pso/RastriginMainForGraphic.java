package com.min.pso;

import com.min.hillclimbing.function.Rastrigin;

public class RastriginMainForGraphic {

    public static void main(String[] args) {
        PSO pso = new PSO(
                new Rastrigin(-5.12, 5.12, 30),
                100,
                1000,
                0,
                1,
                1.0,
                0.0,
                2.0,
                2.0
        );
        pso.execute();
    }
}
