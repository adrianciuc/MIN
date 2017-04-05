package com.min.hillclimbing.function;

import com.min.hillclimbing.solution.RandomSolutionBuilder;
import com.min.hillclimbing.solution.Solution;

public class SolutionGeneratorService {

    private final RandomSolutionBuilder builder;

    public SolutionGeneratorService() {
        this.builder = new RandomSolutionBuilder();
    }

    public Solution getRandom(Function function) {
        return builder.randomSolutionOfSize(
                function.getNumberOfElementsInSolution(),
                function.getSizeOfElementInSolution());
    }
}
