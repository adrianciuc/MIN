package com.min.attraction;

import com.min.hillclimbing.HillClimbing;
import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.solution.BinaryToIntegerTranslator;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.solution.SolutionResult;

import java.util.List;

import static java.util.Collections.shuffle;

public class AttractionHillClimbing  extends HillClimbing {

    private BinaryToIntegerTranslator binaryToIntegerTranslator;

    public AttractionHillClimbing(Function function, Integer iterations) {
        super(function, iterations);
        this.binaryToIntegerTranslator = new BinaryToIntegerTranslator();
    }

    public SolutionResult run(Solution solution) {
        Solution solutionToTry = solution;
        SolutionResult solutionResult = null;
        SolutionResult solutionResult1 = new SolutionResult(null, Double.MIN_VALUE);
        for (int i = 0; i < iterations; i++) {
            solutionResult = findGlobalMin(solutionToTry);
            if (solutionResult.getResult() > solutionResult1.getResult()) {
                solutionResult1 = solutionResult;
                System.out.println("Found best at : " + i + " with value: " + binaryToIntegerTranslator.translateToDouble(solutionResult1.getSolution().getRepresentation())[0]);
            }
            solutionToTry = solutionResult1.getSolution();
        }
        return solutionResult1;
    }

    protected SolutionResult findGlobalMin(Solution initialSolution) {
        Solution solutionToEvaluate = initialSolution;
        double[] solutionTranslation = binaryToIntegerTranslator.translateToDouble(solutionToEvaluate.getRepresentation());
        double solutionResult = function.evaluateFor(solutionTranslation);
        List<Solution> hammingNeighbours = hammingNeighboursService.getHammingNeighboursOf(solutionToEvaluate);
        for (Solution hammingNeighbour : hammingNeighbours) {
            double[] neighbourTranslation = binaryToIntegerTranslator.translateToDouble(hammingNeighbour.getRepresentation());
            double neighbourResult = function.evaluateFor(neighbourTranslation);
            if (neighbourResult > solutionResult) {
                solutionResult = neighbourResult;
                solutionToEvaluate = hammingNeighbour;
            }
        }
        return new SolutionResult(solutionToEvaluate, solutionResult);
    }
}
