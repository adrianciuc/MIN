package com.min.pso;

import com.min.hillclimbing.function.Rastrigin;

import static java.util.stream.IntStream.range;

public class RastriginPsoMain {

    public static void main(String[] args) {
        range(0, 1).forEach(it -> executePSO());
    }

    private static void executePSO() {
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
        Particle particle = pso.execute();
//        System.out.println(particle.getBestFitness());
    }
}
