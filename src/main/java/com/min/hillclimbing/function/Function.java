package com.min.hillclimbing.function;

public abstract class Function {

    private final double lowerBound;
    private final double upperBound;
    private final int numberOfElementsInSolution;

    Function(double lowerBound, double upperBound,
             int numberOfElementsInSolution) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.numberOfElementsInSolution = numberOfElementsInSolution;
    }

    public int getNumberOfElementsInSolution() {
        return numberOfElementsInSolution;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public abstract double evaluateFor(double[] candidateSolution);
}
