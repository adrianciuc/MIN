package com.min.genetic.algorithm.population;

import java.util.Random;

import static com.min.Utils.coppy;

public class PopulationMutationService {

    protected double mutationProbability;

    public PopulationMutationService(double mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

    public void mutate(Population population) {
        Random random = new Random();
        for (int i = 0; i < population.getSolutions().size(); i++) {
            int[][] representation = coppy(population.getSolutions().get(i).getSize(),
                    population.getSolutions().get(i).getSizeOfEachElement(),
                    population.getSolutions().get(i).getRepresentation());
            double probability = random.nextDouble();
            if (probability < mutationProbability) {
                int[][] selectedRepresentation = mutateRepresentation(representation);
                population.getSolutions().get(i).setRepresentation(selectedRepresentation);
            }
        }
    }

    protected int[][] mutateRepresentation(int[][] representation) {
        int[][] mutated = coppy(representation.length, representation[0].length, representation);
        Random random = new Random();
        int selectedChromosomeIndex = random.nextInt(mutated.length);
        int selectedBitIndex = random.nextInt(mutated[selectedChromosomeIndex].length);
        mutated[selectedChromosomeIndex][selectedBitIndex] = - mutated[selectedChromosomeIndex][selectedBitIndex] + 1;
        return mutated;
    }
}
