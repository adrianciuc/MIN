package com.min.hillclimbing.solution;

public class SolutionResult {

    private final Solution solution;
    private final double result;

    public SolutionResult(Solution solution, double result) {
        this.solution = solution;
        this.result = result;
    }

    public Solution getSolution() {
        return solution;
    }

    public double getResult() {
        return result;
    }
}
