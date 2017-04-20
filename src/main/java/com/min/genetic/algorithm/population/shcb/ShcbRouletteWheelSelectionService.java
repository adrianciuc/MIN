package com.min.genetic.algorithm.population.shcb;

import com.min.genetic.algorithm.population.RouletteWheelSelectionService;

public class ShcbRouletteWheelSelectionService extends RouletteWheelSelectionService {

    public ShcbRouletteWheelSelectionService(double epsilon) {
        super(epsilon);
        this.fitnessCalculatorService = new ShcbPopulationFitnessCalculatorService(epsilon);
        this.cumulativeProbabilityService = new ShcbPopulationCumulativeProbabilityService(epsilon);
    }
}
