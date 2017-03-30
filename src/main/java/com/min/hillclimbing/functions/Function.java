package com.min.hillclimbing.functions;

public abstract class Function {

    private final double lowerBound;
    private final double upperBound;
    private final int numberOfElementsInSolution;
    private final int sizeOfElementInSolution;

    Function(double lowerBound, double upperBound,
             int numberOfElementsInSolution, int sizeOfElementInSolution) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.numberOfElementsInSolution = numberOfElementsInSolution;
        this.sizeOfElementInSolution = sizeOfElementInSolution;
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

    public int getSizeOfElementInSolution() {
        return sizeOfElementInSolution;
    }

    public abstract Double evaluateFor(double[][] input);
}
