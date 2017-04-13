package com.min.hillclimbing.function;

import com.min.hillclimbing.solution.RandomSolutionBuilder;
import com.min.hillclimbing.solution.Solution;

public class SolutionGeneratorService {

    protected RandomSolutionBuilder builder;
    protected Math math;

    public SolutionGeneratorService() {
        this.builder = new RandomSolutionBuilder();
        this.math = new Math();
    }

    public Solution getRandom(Function function) {
        return builder.randomSolutionOfSize(function.getNumberOfElementsInSolution(),
                math.computeBitsNumberForInterval(function.getLowerBound(), function.getUpperBound()));
    }
}
