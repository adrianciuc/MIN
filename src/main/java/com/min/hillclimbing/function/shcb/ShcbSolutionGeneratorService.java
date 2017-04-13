package com.min.hillclimbing.function.shcb;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.Shcb;
import com.min.hillclimbing.function.SolutionGeneratorService;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.solution.shcb.ShcbSolution;

public class ShcbSolutionGeneratorService extends SolutionGeneratorService {

    public Solution getRandom(Function function) {
        if (function instanceof Shcb) {
            Shcb shcb = (Shcb) function;
            Solution firstSolution = builder.randomSolutionOfSize(1,
                    math.computeBitsNumberForInterval(shcb.getLowerBound(), shcb.getUpperBound()));
            Solution secondSolution = builder.randomSolutionOfSize(1,
                    math.computeBitsNumberForInterval(shcb.getSecondLowerBound(), shcb.getSecondUpperBound()));
            return new ShcbSolution(firstSolution.getSize(), firstSolution.getSizeOfEachElement(),
                    firstSolution.getRepresentation(),
                    secondSolution.getSize(), secondSolution.getSizeOfEachElement(),
                    secondSolution.getRepresentation());
        } else {
            throw new IllegalArgumentException(function + " is not a SHCB function");
        }
    }
}
