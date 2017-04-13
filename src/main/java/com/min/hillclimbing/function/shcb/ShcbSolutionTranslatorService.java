package com.min.hillclimbing.function.shcb;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.Shcb;
import com.min.hillclimbing.function.SolutionTranslatorService;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.solution.shcb.ShcbSolution;

public class ShcbSolutionTranslatorService extends SolutionTranslatorService {

    public double[] translate(Solution solution, Function function) {
        ShcbSolution shcb = (ShcbSolution) solution;
        Shcb shcbFunction = (Shcb) function;
        int[] firstTranslated = binaryToIntegerTranslator.translate(shcb.getRepresentation());
        int[] secondTranslated = binaryToIntegerTranslator.translate(shcb.getSecondRepresentation());
        double[] firstInInterval =
                integerToDoubleIntervalTranslator.translate(
                        firstTranslated, shcbFunction.getLowerBound(), shcbFunction.getUpperBound());
        double[] secondInInterval =
                integerToDoubleIntervalTranslator.translate(
                        secondTranslated, shcbFunction.getSecondLowerBound(), shcbFunction.getSecondUpperBound());
        double[] toReturn = new double[2];
        toReturn[0] = firstInInterval[0];
        toReturn[1] = secondInInterval[0];
        return toReturn;
    }
}
