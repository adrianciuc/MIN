package com.min.hillclimbing.solution.shcb;

import com.min.hillclimbing.HillClimbing;
import com.min.hillclimbing.function.Shcb;
import com.min.hillclimbing.shcb.ShcbHillClimbing;
import com.min.hillclimbing.solution.SolutionResult;

public class ShcbMain {

    public static void main(String[] args) {
        HillClimbing hillClimbing;
        SolutionResult intermediateSolution;
        SolutionResult solutionResult = null;
        for (int i = 0; i < 100; i++) {
            hillClimbing = new ShcbHillClimbing(new Shcb(-3, 3, -2, 2, 1), 1000);
            intermediateSolution = hillClimbing.run();
            if (solutionResult == null || intermediateSolution.getResult() < solutionResult.getResult()) {
                solutionResult = intermediateSolution;
                System.out.println("Intermediate Result: " + solutionResult.getResult() + " at iteration " + i);
            }
        }
    }
}
