package com.min.genetic.algorithm;

import com.min.hillclimbing.function.Griewangk;

import java.io.IOException;

import static java.nio.file.Files.write;
import static java.nio.file.Paths.get;
import static java.util.stream.IntStream.range;

public class GriewangkMain {

    public static void main(String[] args) throws IOException {
        String FILE_WITH_RESULTS = "C:\\Users\\adria\\results.csv";
        StringBuffer buffer = new StringBuffer();
        range(0, 30)
                .forEach( it -> buffer
                        .append(executeGeneticAlgorithm(5))
                        .append(",")
                        .append(executeGeneticAlgorithm(10))
                        .append(",")
                        .append(executeGeneticAlgorithm(30))
                        .append("\n"));
        write(get(FILE_WITH_RESULTS), buffer.toString().getBytes());
    }

    private static double executeGeneticAlgorithm(Integer numberOfElementsInSolution) {
        GeneticAlgorithm algorithm = new GeneticAlgorithm(
                new Griewangk(-600, 600, numberOfElementsInSolution),
                100,
                200,
                0.000001,
                0.1,
                0.4
        );
        return algorithm.run();
    }
}
