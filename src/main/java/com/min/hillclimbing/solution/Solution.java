package com.min.hillclimbing.solution;

import static com.min.Utils.coppy;

public class Solution {

    private int[][] representation;
    private int size;
    private int sizeOfEachElement;

    public Solution(int size, int sizeOfEachElement) {
        this.representation = new int[size][sizeOfEachElement];
        this.size = size;
        this.sizeOfEachElement = sizeOfEachElement;
    }

    public Solution(int size, int sizeOfEachElement, int[][] representation) {
        this.representation = representation;
        this.size = size;
        this.sizeOfEachElement = sizeOfEachElement;
    }

    public Solution createCopy() {
        int[][] rep = coppy(size, sizeOfEachElement, representation);
        return new Solution(size, sizeOfEachElement, rep);
    }

    public int[][] getRepresentation() {
        return representation;
    }

    public void setRepresentation(int[][] representation) {
        this.representation = representation;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSizeOfEachElement() {
        return sizeOfEachElement;
    }

    public void setSizeOfEachElement(int sizeOfEachElement) {
        this.sizeOfEachElement = sizeOfEachElement;
    }
}
