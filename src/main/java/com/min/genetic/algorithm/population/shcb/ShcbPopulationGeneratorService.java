package com.min.genetic.algorithm.population.shcb;

import com.min.genetic.algorithm.population.Population;
import com.min.genetic.algorithm.population.PopulationGeneratorService;
import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.shcb.ShcbSolutionGeneratorService;

public class ShcbPopulationGeneratorService extends PopulationGeneratorService {

    public ShcbPopulationGeneratorService() {
        this.solutionGeneratorService = new ShcbSolutionGeneratorService();
    }
}
