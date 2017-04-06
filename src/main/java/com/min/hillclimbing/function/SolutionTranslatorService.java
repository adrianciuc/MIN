package com.min.hillclimbing.function;

import com.min.hillclimbing.solution.BinaryToIntegerTranslator;
import com.min.hillclimbing.solution.IntegerToDoubleIntervalTranslator;
import com.min.hillclimbing.solution.Solution;

public class SolutionTranslatorService {

    private final BinaryToIntegerTranslator binaryToIntegerTranslator;
    private final IntegerToDoubleIntervalTranslator integerToDoubleIntervalTranslator;

    public SolutionTranslatorService(BinaryToIntegerTranslator binaryToIntegerTranslator,
                                     IntegerToDoubleIntervalTranslator integerToDoubleIntervalTranslator) {
        this.binaryToIntegerTranslator = binaryToIntegerTranslator;
        this.integerToDoubleIntervalTranslator = integerToDoubleIntervalTranslator;
    }

    public double[] translate(Solution solution, Function function) {
        int[] translated = binaryToIntegerTranslator.translate(solution.getRepresentation());
        return integerToDoubleIntervalTranslator.translate(
                translated,
                function.getLowerBound(),
                function.getUpperBound());
    }
}