package com.min.hillclimbing.solution;

import java.util.ArrayList;
import java.util.List;

public class HammingNeighboursService {

    public List<Solution> getHammingNeighboursOf(Solution solution) {
        ArrayList<Solution> neighbours = new ArrayList<>();
        for (int i = 0; i < solution.getRepresentation().length; i++) {
            neighbours.addAll(getMutationsOfElement(solution.getRepresentation()[i], i, solution));
        }
        return neighbours;
    }

    private List<Solution> getMutationsOfElement(int[] element, int elementIndex, Solution originalSolution) {
        List<Solution> mutations = new ArrayList<>();
        int[][] originalRepresentation = originalSolution.getRepresentation();
        for (int i = 0; i < element.length; i++) {
            int[] mutation = element.clone();
            mutation[i] = element[i] == 0 ? 1 : 0;
            int[][] newRepresentation = originalRepresentation.clone();
            newRepresentation[elementIndex] = mutation;
            mutations.add(new Solution(
                    originalSolution.getSize(),
                    originalSolution.getSizeOfEachElement(),
                    newRepresentation));
        }
        return mutations;
    }
}
