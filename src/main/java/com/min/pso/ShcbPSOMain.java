package com.min.pso;

import com.min.hillclimbing.function.Shcb;

import java.io.IOException;

import static java.nio.file.Files.write;
import static java.nio.file.Paths.get;
import static java.util.stream.IntStream.range;

public class ShcbPSOMain {

    public static void main(String[] args) throws IOException {
        String FILE_WITH_RESULTS = "C:\\Users\\adria\\results.csv";
        StringBuffer buffer = new StringBuffer();
        range(0, 30)
                .forEach( it -> buffer
                        .append(executePSO(2))
                        .append("\n"));
        write(get(FILE_WITH_RESULTS), buffer.toString().getBytes());
    }

    private static double executePSO(Integer numberOfElementsInSolution) {
        PSO pso = new PSO(
                new Shcb(-3, 3, -2, 2,numberOfElementsInSolution),
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
