package com.min.attraction;

import com.min.hillclimbing.HillClimbing;
import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.solution.SolutionResult;

import java.util.List;

import static java.util.Collections.shuffle;

public class AttractionHillClimbing  extends HillClimbing {

    public AttractionHillClimbing(Function function, Integer iterations) {
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

    protected SolutionResult findGlobalMin(Solution initialSolution) {
        Solution solutionToEvaluate = initialSolution;
        double[] solutionTranslation = solutionTranslatorService.translate(solutionToEvaluate, function);
        double solutionResult = function.evaluateFor(solutionTranslation);
        List<Solution> hammingNeighbours = hammingNeighboursService.getHammingNeighboursOf(solutionToEvaluate);
        shuffle(hammingNeighbours);
        for (Solution hammingNeighbour : hammingNeighbours) {
            double[] neighbourTranslation = solutionTranslatorService.translate(hammingNeighbour, function);
            double neighbourResult = function.evaluateFor(neighbourTranslation);
            if (neighbourResult < solutionResult) {
                solutionResult = neighbourResult;
                solutionToEvaluate = hammingNeighbour;
                break;
            }
        }
        return new SolutionResult(solutionToEvaluate, solutionResult);
    }
}
