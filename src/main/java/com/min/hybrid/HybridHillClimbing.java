package com.min.hybrid;

import com.min.hillclimbing.HillClimbing;
import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.solution.SolutionResult;

public class HybridHillClimbing extends HillClimbing {

    public HybridHillClimbing(Function function, Integer iterations) {
        super(function, iterations);
    }

    public SolutionResult run(Solution solution) {
        Solution solutionToTry = solution;
        SolutionResult solutionResult = null;
        for (int i = 0; i < iterations; i++) {
            solutionResult = findGlobalMin(solutionToTry);
            solutionToTry = solutionResult.getSolution();
        }
        return solutionResult;
    }
}
