package com.min.hillclimbing;

public class Function {

    private final double lowerBound;
    private final double upperBound;
    private final int numberOfElementsInSolution;
    private final int sizeOfElementInSolution;

    Function(double lowerBound, double upperBound, int numberOfElementsInSolution) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.numberOfElementsInSolution = numberOfElementsInSolution;
        this.sizeOfElementInSolution =
                new Math().computeBitsNumberForInterval(lowerBound, upperBound);
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
}
