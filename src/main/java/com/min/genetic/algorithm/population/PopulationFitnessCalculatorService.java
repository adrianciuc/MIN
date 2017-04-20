package com.min.genetic.algorithm.population;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.SolutionTranslatorService;
import com.min.hillclimbing.solution.Solution;

public class PopulationFitnessCalculatorService {

    protected SolutionTranslatorService translatorService;
    private double epsilon;

    public PopulationFitnessCalculatorService(double epsilon) {
        this.translatorService = new SolutionTranslatorService();
    }

    public double calculateFitnessFor(Population population, Function function) {
        double populationFitness = 0;
        for (int i = 0; i < population.getSolutions().size(); i++) {
            populationFitness = populationFitness + calculateFitnessFor(population.getSolutions().get(i), function);
        }
        return populationFitness;
    }

    public double calculateFitnessFor(Solution solution, Function function) {
        double[] translatedSolution = translatorService.translate(solution, function);
        return 1 / (function.evaluateFor(translatedSolution) + epsilon);
    }
}
