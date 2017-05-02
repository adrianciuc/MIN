package com.min.genetic.algorithm.population;

import com.min.hillclimbing.solution.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.min.Utils.coppy;

public class PopulationCrossoverService {

    private double crossoverProbability;

    public PopulationCrossoverService(double crossoverProbability) {
        this.crossoverProbability = crossoverProbability;
    }

    public void crossoverPopulation(Population population) {
        Random random = new Random();
        List<Integer> selectedIndex = new ArrayList<>();
        for (int i = 0; i < population.getSolutions().size(); i++) {
            double probability = random.nextDouble();
            if (probability < crossoverProbability) {
                selectedIndex.add(i);
            }
        }
        int randomIndex, chosenIndex1, chosenIndex2;
        while (selectedIndex.size() > 1) {
            randomIndex = random.nextInt(selectedIndex.size());
            chosenIndex1 = selectedIndex.get(randomIndex);
            selectedIndex.remove((Integer) chosenIndex1);

            randomIndex = random.nextInt(selectedIndex.size());
            chosenIndex2 = selectedIndex.get(randomIndex);
            selectedIndex.remove((Integer) chosenIndex2);

            List<Solution> crossedIndividuals = crossoverIndividuals(population.getSolutions().get(chosenIndex1),
                    population.getSolutions().get(chosenIndex2));
            population.getSolutions().set(chosenIndex1, crossedIndividuals.get(0));
            population.getSolutions().set(chosenIndex2, crossedIndividuals.get(1));
        }
    }

    protected List<Solution> crossoverIndividuals(Solution firstSolution, Solution secondSolution) {
        List<Solution> crossoverIndividuals = new ArrayList<>();
        Random random = new Random();
        if (!random.nextBoolean()) {
            int[][] aux = coppy(firstSolution.getRepresentation().length,
                    firstSolution.getRepresentation()[0].length,
                    firstSolution.getRepresentation());
            firstSolution.setRepresentation(coppy(secondSolution.getRepresentation().length,
                    secondSolution.getRepresentation()[0].length,
                    secondSolution.getRepresentation()));
            secondSolution.setRepresentation(aux);
        }
        int chromosomeToCross = random.nextInt(firstSolution.getSize());
        int[][] crossedChromosomes = cross(firstSolution.getRepresentation()[chromosomeToCross],
                secondSolution.getRepresentation()[chromosomeToCross]);
        firstSolution.getRepresentation()[chromosomeToCross] = crossedChromosomes[0];
        secondSolution.getRepresentation()[chromosomeToCross] = crossedChromosomes[1];
        crossoverIndividuals.add(firstSolution);
        crossoverIndividuals.add(secondSolution);
        return crossoverIndividuals;
    }

    protected int[][] cross(int[] firstChromosome, int[] secondChromosome) {
        Random random = new Random();
        int position = random.nextInt(firstChromosome.length);
        int[] firstCrossedChromosome = new int[firstChromosome.length];
        int[] secondCrossedChromosome = new int[secondChromosome.length];
        for (int i = 0; i < position; i++) {
            firstCrossedChromosome[i] = firstChromosome[i];
        }
        for (int i = position; i < secondChromosome.length; i++) {
            firstCrossedChromosome[i] = secondChromosome[i];
        }
        for (int i = 0; i < position; i++) {
            secondCrossedChromosome[i] = secondChromosome[i];
        }
        for (int i = position; i < secondChromosome.length; i++) {
            secondCrossedChromosome[i] = firstChromosome[i];
        }
        int[][] crossed = new int[2][firstChromosome.length];
        crossed[0] = firstCrossedChromosome;
        crossed[1] = secondCrossedChromosome;
        return crossed;
    }
}
