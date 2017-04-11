package com.min.hillclimbing.solution;

public class Solution {

    private int[][] representation;
    private int size;
    private int sizeOfEachElement;

    Solution(int size, int sizeOfEachElement) {
        this.representation = new int[size][sizeOfEachElement];
        this.size = size;
        this.sizeOfEachElement = sizeOfEachElement;
    }

    public Solution(int size, int sizeOfEachElement, int[][] representation) {
        this.representation = representation;
        this.size = size;
        this.sizeOfEachElement = sizeOfEachElement;
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
