package com.min.pso;

import com.min.hillclimbing.function.Rastrigin;

import java.io.IOException;

import static java.nio.file.Files.write;
import static java.nio.file.Paths.get;
import static java.util.stream.IntStream.range;

public class RastriginPsoMain {

    public static void main(String[] args) throws IOException {
        String FILE_WITH_RESULTS = "C:\\Users\\adria\\results.csv";
        StringBuffer buffer = new StringBuffer();
        range(0, 30)
                .forEach( it -> buffer
                        .append(executePSO(5))
                        .append(",")
                        .append(executePSO(10))
                        .append(",")
                        .append(executePSO(30))
                        .append("\n"));
        write(get(FILE_WITH_RESULTS), buffer.toString().getBytes());
    }

    private static double executePSO(Integer numberOfIterations) {
        PSO pso = new PSO(
                new Rastrigin(-5.12, 5.12, numberOfIterations),
                100,
                1000,
                0,
                1,
                1.0,
                0.0,
                2.0,
                2.0
        );
        return pso.execute().getBestFitness();
    }
}