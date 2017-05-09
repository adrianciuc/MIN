package com.min.pso;

import com.min.hillclimbing.function.Shcb;

import static java.util.stream.IntStream.range;

public class ShcbPSOMain {

    public static void main(String[] args) {
        range(0, 30).forEach(it -> executePSO());
    }

    private static void executePSO() {
        PSO pso = new PSO(
                new Shcb(-3, 3, -2, 2,2),
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
