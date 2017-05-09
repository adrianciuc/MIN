package com.min.pso;

import com.min.hillclimbing.function.Rosenbrock;

import static java.util.stream.IntStream.range;

public class RosenbrockPSOMain {

    public static void main(String[] args) {
        range(0, 30).forEach(it -> executePSO());
    }

    private static void executePSO() {
        PSO pso = new PSO(
                new Rosenbrock(-2.048, 2.048, 30),
                50,
                200,
                0,
                1,
                1.0,
                0.0,
                2.0,
                2.0
        );
        Particle particle = pso.execute();
        System.out.println(particle.getBestFitness());
    }
}
