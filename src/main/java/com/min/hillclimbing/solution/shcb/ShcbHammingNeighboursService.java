package com.min.hillclimbing.solution.shcb;

import com.min.hillclimbing.solution.HammingNeighboursService;
import com.min.hillclimbing.solution.Solution;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ShcbHammingNeighboursService extends HammingNeighboursService {

    public List<Solution> getHammingNeighboursOf(Solution solution) {
        ShcbSolution shcbSolution = (ShcbSolution) solution;
        List<Solution> firstNeighbours = super.getHammingNeighboursOf(solution);
        List<Solution> firstShcbNeighbours = getFirstShcbNeighbours((ShcbSolution) solution, firstNeighbours);
        Solution secondPartOfShcbSolution = new Solution(
                shcbSolution.getSecondSize(),
                shcbSolution.getSizeOfEachSecondElement(),
                shcbSolution.getSecondRepresentation());
        List<Solution> secondNeighbours = super.getHammingNeighboursOf(secondPartOfShcbSolution);
        List<Solution> secondShcbNeighbours = getSecondShcbNeighbours(shcbSolution, secondNeighbours);
        firstShcbNeighbours.addAll(secondShcbNeighbours);
        return firstShcbNeighbours;
    }

    private List<Solution> getFirstShcbNeighbours(ShcbSolution initial, List<Solution> nonShcbNeighbours) {
        return nonShcbNeighbours.stream()
                .map(it -> new ShcbSolution(
                        it.getSize(),
                        it.getSizeOfEachElement(),
                        it.getRepresentation(),
                        initial.getSecondSize(),
                        initial.getSizeOfEachSecondElement(),
                        initial.getSecondRepresentation())).collect(toList());
    }

    private List<Solution> getSecondShcbNeighbours(ShcbSolution initial, List<Solution> nonShcbNeighbours) {
        return nonShcbNeighbours.stream()
                .map(it -> new ShcbSolution(
                        initial.getSize(),
                        initial.getSizeOfEachElement(),
                        initial.getRepresentation(),
                        it.getSize(),
                        it.getSizeOfEachElement(),
                        it.getRepresentation())).collect(toList());
    }
}
