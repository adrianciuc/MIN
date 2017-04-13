package com.min.hillclimbing;

import com.min.hillclimbing.function.Rastrigin;
import com.min.hillclimbing.solution.SolutionResult;

public class RastriginMain {

    public static void main(String[] args) {
        HillClimbing hillClimbing;
        SolutionResult intermediateSolution;
        SolutionResult solutionResult = null;
        for (int i = 0; i < 500; i++) {
            hillClimbing = new HillClimbing(new Rastrigin(-5.12, 5.12, 5), 1000);
            intermediateSolution = hillClimbing.run();
            if (solutionResult == null || intermediateSolution.getResult() < solutionResult.getResult()) {
                solutionResult = intermediateSolution;
                System.out.println("Intermediate Result: " + solutionResult.getResult() + " at iteration " + i);
            }
        }
    }
}
