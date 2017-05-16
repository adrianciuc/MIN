package com.min.hybrid.shcb;

import com.min.hillclimbing.function.Shcb;

import java.io.IOException;

import static java.nio.file.Files.write;
import static java.nio.file.Paths.get;
import static java.util.stream.IntStream.range;

public class ShcbMain {

    public static void main(String[] args) throws IOException {
        String FILE_WITH_RESULTS = "C:\\Users\\adria\\results.csv";
        StringBuffer buffer = new StringBuffer();
        range(0, 30)
                .forEach( it -> buffer
                        .append(executeHybridAlgorithm(1))
                        .append("\n"));
        write(get(FILE_WITH_RESULTS), buffer.toString().getBytes());
    }

    private static double executeHybridAlgorithm(Integer numberOfElementsInSolution) {
        ShcbHybridAlgorithm algorithm = new ShcbHybridAlgorithm(
                new Shcb(-3, 3, -2, 2, numberOfElementsInSolution),
                100,
                200,
                0.000001,
                0.1,
                0.4,
                0.3
        );
        return algorithm.run();
    }
}
