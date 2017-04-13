package com.min.hillclimbing.solution.shcb;

import com.min.hillclimbing.solution.RandomSolutionBuilder;
import com.min.hillclimbing.solution.Solution;

public class ShcbRandomSolutionBuilder extends RandomSolutionBuilder{

    public ShcbSolution randomSolutionOfSize(int size, int sizeOfEachElement) {
        Solution firstSolution = super.randomSolutionOfSize(size, sizeOfEachElement);
        Solution secondSolution = super.randomSolutionOfSize(size, sizeOfEachElement);
        return new ShcbSolution(
                size,
                sizeOfEachElement,
                firstSolution.getRepresentation(),
                secondSolution.getSize(),
                secondSolution.getSizeOfEachElement(),
                secondSolution.getRepresentation());
    }
}
