package com.min.genetic.algorithm.population;

import com.min.hillclimbing.function.Function;

public class PopulationCumulativeProbabilityService {

    protected PopulationFitnessCalculatorService service;

    public PopulationCumulativeProbabilityService(double epsilon) {
        this.service = new PopulationFitnessCalculatorService(epsilon);
    }

    public double[] cumulativeProbabilityFor(Population population, Function function,
                                             double totalFitness) {
        double[] selectionProbability = getSelectionProbability(population, function, totalFitness);
        double[] cumulativeProbability = new double[population.getSolutions().size()];
        cumulativeProbability[0] = 0.0;
        for (int i = 1; i < population.getSolutions().size() - 1; i++) {
            cumulativeProbability[i] = cumulativeProbability[i - 1] + selectionProbability[i];
        }
        cumulativeProbability[population.getSolutions().size() - 1] = 1.0;
        return cumulativeProbability;
    }

    private double[] getSelectionProbability(Population population, Function function,
                                             double totalFitness) {
        double[] probability = new double[population.getSolutions().size()];
        for (int i = 0; i < population.getSolutions().size(); i++) {
            probability[i] = service.calculateFitnessFor(population.getSolutions().get(i), function) / totalFitness;
        }
        return probability;
    }
}
