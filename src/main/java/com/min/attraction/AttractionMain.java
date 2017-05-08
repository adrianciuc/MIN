package com.min.attraction;

import com.min.hillclimbing.HillClimbing;
import com.min.hillclimbing.function.SolutionTranslatorService;
import com.min.hillclimbing.solution.BinaryToIntegerTranslator;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.solution.SolutionResult;

import java.util.ArrayList;
import java.util.List;

public class AttractionMain {

    public static void main(String[] args) {
        FunctionToEvaluate function = new FunctionToEvaluate(0.0, 31.0, 1);
        AttractionHillClimbing hillClimbing = new AttractionHillClimbing(function, 100);
        for (int i = 0; i < 32; i++) {
            int[][] representation = new int[1][5];
            representation[0] = get(i);

            SolutionResult run = hillClimbing.run(
                    new Solution(1, 5, representation));
            System.out.println("Pool of attraction for: " + i +" is: "
                    + new BinaryToIntegerTranslator()
                    .translateToDouble(
                            run.getSolution().getRepresentation())[0]);
            System.out.println("Result at it:" + i +" is: " + run.getResult());
        }
    }

    public static int[] get(Integer i) {
        List<Integer> bits = new ArrayList<>();
        while(i > 0) {
            bits.add(i%2);
            i = i/2;
        }
        int[] toReturn = new int[5];
        for (int b = bits.size() - 1; b >= 0; b--) {
            toReturn[bits.size() - 1 - b + 5 - bits.size()] = bits.get(b);
        }
//        for (int j = 0; j < toReturn.length; j++) {
//            System.out.println(toReturn[j]);
//        }
        return toReturn;
    }
}
