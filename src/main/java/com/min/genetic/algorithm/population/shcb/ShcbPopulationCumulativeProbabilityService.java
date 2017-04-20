package com.min.genetic.algorithm.population.shcb;

import com.min.genetic.algorithm.population.PopulationCumulativeProbabilityService;

public class ShcbPopulationCumulativeProbabilityService extends PopulationCumulativeProbabilityService {

    public ShcbPopulationCumulativeProbabilityService(double epsilon) {
        super(epsilon);
        this.service = new ShcbPopulationFitnessCalculatorService(epsilon);
    }
}
