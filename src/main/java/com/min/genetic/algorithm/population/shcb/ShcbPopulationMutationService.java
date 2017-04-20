package com.min.genetic.algorithm.population.shcb;

import com.min.genetic.algorithm.population.Population;
import com.min.genetic.algorithm.population.PopulationMutationService;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.solution.shcb.ShcbSolution;

import java.util.Random;

public class ShcbPopulationMutationService extends PopulationMutationService {

    public ShcbPopulationMutationService(double mutationProbability) {
        super(mutationProbability);
    }

    public void mutate(Population population) {
        Random random = new Random();
        for (int i = 0; i < population.getSolutions().size(); i++) {
            int[][] representation = population.getSolutions().get(i).getRepresentation().clone();
            double probability = random.nextDouble();
            if (probability < mutationProbability) {
                Solution selectedsolution = mutateRepresentation((ShcbSolution) population.getSolutions().get(i));
                population.getSolutions().set(i, selectedsolution);
            }
        }
    }

    private Solution mutateRepresentation(ShcbSolution  solution) {
        Random random = new Random();
        int selectedChromosomeIndex = random.nextInt(2);
        int[][] mutated;
        if (selectedChromosomeIndex == 0) {
            mutated = solution.getRepresentation().clone();
        } else {
            mutated = solution.getSecondRepresentation().clone();
        }
        int selectedBitIndex = random.nextInt(mutated[0].length);
        mutated[0][selectedBitIndex] = - mutated[0][selectedBitIndex] + 1;
        if (selectedChromosomeIndex == 0) {
            return new ShcbSolution(solution.getSize(),
                    solution.getSizeOfEachSecondElement(),
                    mutated,
                    solution.getSecondSize(),
                    solution.getSizeOfEachSecondElement(),
                    solution.getSecondRepresentation());
        } else {
            return new ShcbSolution(solution.getSize(),
                    solution.getSizeOfEachSecondElement(),
                    solution.getRepresentation(),
                    solution.getSecondSize(),
                    solution.getSizeOfEachSecondElement(),
                    mutated);
        }
    }
}
