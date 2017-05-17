package com.min.genetic.algorithm;

import com.min.genetic.algorithm.population.*;
import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.SolutionTranslatorService;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.solution.shcb.ShcbSolution;

import java.io.IOException;
import java.util.stream.Collectors;

import static com.min.hillclimbing.function.Rastrigin.EVALUATION_COUNTER;
import static java.nio.file.Files.write;
import static java.nio.file.Paths.get;

public class GeneticAlgorithm {

    protected PopulationGeneratorService populationGenerator;
    protected Function function;
    protected int populationSize;
    protected int numberOfIterations;
    protected RouletteWheelSelectionService rouletteWheelSelectionService;
    protected PopulationMutationService mutationService;
    protected PopulationCrossoverService crossoverService;
    protected PopulationBestIndividualSelectorService bestIndividualSelectorService;
    protected SolutionTranslatorService translatorService;
    protected PopulationFitnessCalculatorService fitnessCalculatorService;
    protected StringBuffer buffer;

    public GeneticAlgorithm(Function function, int populationSize,
                            int numberOfIterations, double epsilon, double mutationProbability,
                            double crossoverProbability) {
        this.populationGenerator = new PopulationGeneratorService();
        this.function = function;
        this.populationSize = populationSize;
        this.numberOfIterations = numberOfIterations;
        this.rouletteWheelSelectionService = new RouletteWheelSelectionService(epsilon);
        this.mutationService = new PopulationMutationService(mutationProbability);
        this.crossoverService = new PopulationCrossoverService(crossoverProbability);
        this.bestIndividualSelectorService = new PopulationBestIndividualSelectorService();
        this.translatorService = new SolutionTranslatorService();
        this.fitnessCalculatorService = new PopulationFitnessCalculatorService(epsilon);
        buffer = new StringBuffer();
    }

    public double run() {
        Population population = populationGenerator.generatePopulation(populationSize, function);
        double bestValue = Double.MAX_VALUE;
        Solution bestGlobalIndividual = null;
        double bestIndividualFitness;
        int iterations = 0;
        for (int i = 0; i < numberOfIterations; i++) {
            rouletteWheelSelectionService.runOver(population, function);
            mutationService.mutate(population);
            crossoverService.crossoverPopulation(population);

            Solution bestIndividual = bestIndividualSelectorService.getBestIndividualFrom(population, function);
            double[] translatedIndividual = translatorService.translate(bestIndividual, function);
            double currentPopulationBestIndividualValue = function.evaluateFor(translatedIndividual);

            if (currentPopulationBestIndividualValue < bestValue) {
                bestValue = currentPopulationBestIndividualValue;
                bestGlobalIndividual = bestIndividual;
                iterations = i;
                buffer.append(EVALUATION_COUNTER)
                        .append(",")
                        .append(currentPopulationBestIndividualValue)
                        .append("\n");
                System.out.println("Result after " + EVALUATION_COUNTER +" is: " + currentPopulationBestIndividualValue);
            }
        }
        bestIndividualFitness = fitnessCalculatorService.calculateFitnessFor(bestGlobalIndividual, function);
        try {
            write(get("C:\\Users\\adria\\results_genetic.csv"), buffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(
                "Best function value is: " + bestValue + " for a solution with fitness: " + bestIndividualFitness + " after " + iterations + " iterations.");
        return bestValue;
    }
}
