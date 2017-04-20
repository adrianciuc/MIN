package com.min.genetic.algorithm.population.shcb;

import com.min.genetic.algorithm.population.PopulationFitnessCalculatorService;
import com.min.hillclimbing.function.shcb.ShcbSolutionTranslatorService;

public class ShcbPopulationFitnessCalculatorService extends PopulationFitnessCalculatorService {

    public ShcbPopulationFitnessCalculatorService(double epsilon) {
        super(epsilon);
        this.translatorService = new ShcbSolutionTranslatorService();
    }
}
