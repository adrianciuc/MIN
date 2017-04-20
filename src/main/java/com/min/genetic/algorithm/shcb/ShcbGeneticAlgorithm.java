package com.min.genetic.algorithm.shcb;

import com.min.genetic.algorithm.GeneticAlgorithm;
import com.min.genetic.algorithm.population.shcb.*;
import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.shcb.ShcbSolutionTranslatorService;

public class ShcbGeneticAlgorithm extends GeneticAlgorithm {


    public ShcbGeneticAlgorithm(Function function, int populationSize, int numberOfIterations, double epsilon,
                                double mutationProbability, double crossoverProbability) {
        super(function, populationSize, numberOfIterations, epsilon, mutationProbability, crossoverProbability);
        this.translatorService = new ShcbSolutionTranslatorService();
        this.populationGenerator = new ShcbPopulationGeneratorService();
        this.rouletteWheelSelectionService = new ShcbRouletteWheelSelectionService(epsilon);
        this.mutationService = new ShcbPopulationMutationService(mutationProbability);
        this.crossoverService = new ShcbPopulationCrossoverService(crossoverProbability);
        this.bestIndividualSelectorService = new ShcbPopulationBestIndividualSelectorService();
        this.fitnessCalculatorService = new ShcbPopulationFitnessCalculatorService(epsilon);
    }
}
