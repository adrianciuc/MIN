package com.min.hillclimbing.solution.shcb;

import com.min.hillclimbing.solution.Solution;

import static com.min.Utils.coppy;

public class ShcbSolution extends Solution {

    private final int secondSize;
    private final int sizeOfEachSecondElement;
    private final int[][] secondRepresentation;

    ShcbSolution(int size, int sizeOfEachElement, int secondSize, int sizeOfEachSecondElement) {
        super(size, sizeOfEachElement);
        this.secondSize = secondSize;
        this.sizeOfEachSecondElement = sizeOfEachSecondElement;
        this.secondRepresentation = new int[secondSize][sizeOfEachSecondElement];
    }

    public ShcbSolution(int size, int sizeOfEachElement,
                 int[][] representation,
                 int secondSize, int sizeOfEachSecondElement,
                 int[][] secondRepresentation) {
        super(size, sizeOfEachElement);
        super.setRepresentation(representation);
        this.secondSize = secondSize;
        this.sizeOfEachSecondElement = sizeOfEachSecondElement;
        this.secondRepresentation = secondRepresentation;
    }

    public Solution createCopy() {
        int[][] rep1 = coppy(getSize(), getSizeOfEachElement(), getRepresentation());
        int[][] rep2 = coppy(secondSize, sizeOfEachSecondElement, secondRepresentation);
        return new ShcbSolution(getSize(), getSizeOfEachElement(), rep1, secondSize, sizeOfEachSecondElement, rep2);
    }

    public int[][] getSecondRepresentation() {
        return secondRepresentation;
    }

    public int getSecondSize() {
        return secondSize;
    }

    public int getSizeOfEachSecondElement() {
        return sizeOfEachSecondElement;
    }
}
