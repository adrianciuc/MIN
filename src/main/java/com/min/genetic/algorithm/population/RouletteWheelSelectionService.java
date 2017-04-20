package com.min.genetic.algorithm.population;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.solution.Solution;

import java.util.*;

public class RouletteWheelSelectionService {

    protected PopulationFitnessCalculatorService fitnessCalculatorService;
    protected PopulationCumulativeProbabilityService cumulativeProbabilityService;
    private double epsilon;

    public RouletteWheelSelectionService(double epsilon) {
        this.fitnessCalculatorService = new PopulationFitnessCalculatorService(epsilon);
        this.cumulativeProbabilityService = new PopulationCumulativeProbabilityService(epsilon);
    }

    public void runOver(Population population, Function function) {
        Random random = new Random();
        List<Solution> selectedSolutions = new ArrayList<>();
        double totalFitness = fitnessCalculatorService.calculateFitnessFor(population, function);
        double[] cumulativeProbability =
                cumulativeProbabilityService.cumulativeProbabilityFor(population, function, totalFitness);
        for (int i = 0 ; i < population.getSolutions().size(); i++) {
            double randomSelector = random.nextDouble();
            for (int j = 1; j < cumulativeProbability.length; j++) {
                if (cumulativeProbability[j - 1] <= randomSelector && randomSelector < cumulativeProbability[j]) {
                    selectedSolutions.add(population.getSolutions().get(j));
                    if (selectedSolutions.size() == population.getSolutions().size()) {
                        break;
                    }
                }
            }
            if (selectedSolutions.size() == population.getSolutions().size()) {
                break;
            }
        }
        population.setSolutions(selectedSolutions);
    }
}
