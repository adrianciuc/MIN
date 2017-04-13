package com.min.hillclimbing.function;

import com.google.common.annotations.VisibleForTesting;
import com.min.hillclimbing.solution.BinaryToIntegerTranslator;
import com.min.hillclimbing.solution.IntegerToDoubleIntervalTranslator;
import com.min.hillclimbing.solution.Solution;

public class SolutionTranslatorService {

    @VisibleForTesting
    protected final BinaryToIntegerTranslator binaryToIntegerTranslator;
    @VisibleForTesting
    protected final IntegerToDoubleIntervalTranslator integerToDoubleIntervalTranslator;

    public SolutionTranslatorService() {
        this.binaryToIntegerTranslator = new BinaryToIntegerTranslator();
        this.integerToDoubleIntervalTranslator = new IntegerToDoubleIntervalTranslator();
    }

    public double[] translate(Solution solution, Function function) {
        int[] translated = binaryToIntegerTranslator.translate(solution.getRepresentation());
//        System.out.print("[ ");
//        for (int i : translated) {
//            System.out.print(i + ", ");
//        }
//        System.out.print(" ]\n");
        return integerToDoubleIntervalTranslator.translate(
                translated,
                function.getLowerBound(),
                function.getUpperBound());
    }

    public BinaryToIntegerTranslator getBinaryToIntegerTranslator() {
        return binaryToIntegerTranslator;
    }

    public IntegerToDoubleIntervalTranslator getIntegerToDoubleIntervalTranslator() {
        return integerToDoubleIntervalTranslator;
    }
}
