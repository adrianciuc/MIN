package com.min.hybrid;

import com.min.genetic.algorithm.GeneticAlgorithm;
import com.min.genetic.algorithm.population.Population;
import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.solution.Solution;

import java.util.Random;

public class HybridAlgorithm extends GeneticAlgorithm {

    private double hcProbability;

    public HybridAlgorithm(Function function, int populationSize, int numberOfIterations, double epsilon,
                           double mutationProbability, double crossoverProbability, double hcProbability) {
        super(function, populationSize, numberOfIterations, epsilon, mutationProbability, crossoverProbability);
        this.hcProbability = hcProbability;
    }

    public void run() {
        Population population = populationGenerator.generatePopulation(populationSize, function);
        double bestValue = Double.MAX_VALUE;
        Solution bestGlobalIndividual = null;
        double bestIndividualFitness;
        int iterations = 0;
        for (int i = 0; i < numberOfIterations; i++) {
            rouletteWheelSelectionService.runOver(population, function);
            mutationService.mutate(population);
            crossoverService.crossoverPopulation(population);

            Random random = new Random();
            double hillClimbingProbability = random.nextDouble();
            if (hillClimbingProbability < hcProbability) {
                for (int j = 0; j < population.getSolutions().size(); j++) {
                    HybridHillClimbing hc = new HybridHillClimbing(function, 1);
                    population.getSolutions().set(j, hc.run(population.getSolutions().get(j)).getSolution());
                }
            }

            Solution bestIndividual = bestIndividualSelectorService.getBestIndividualFrom(population, function);
            double[] translatedIndividual = translatorService.translate(bestIndividual, function);
            double currentPopulationBestIndividualValue = function.evaluateFor(translatedIndividual);
            System.out.println("Best individual at it: " + i + " is: " + currentPopulationBestIndividualValue);

            if (currentPopulationBestIndividualValue < bestValue) {
                bestValue = currentPopulationBestIndividualValue;
                bestGlobalIndividual = bestIndividual;
                iterations = i;
            }
        }
        bestIndividualFitness = fitnessCalculatorService.calculateFitnessFor(bestGlobalIndividual, function);
        System.out.println(
                "Best function value is: " + bestValue + " for a solution with fitness: " + bestIndividualFitness + " after " + iterations + " iterations.");
    }
}
