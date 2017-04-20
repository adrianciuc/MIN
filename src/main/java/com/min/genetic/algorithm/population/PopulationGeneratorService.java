package com.min.genetic.algorithm.population;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.SolutionGeneratorService;
import com.min.hillclimbing.solution.Solution;

import java.util.ArrayList;
import java.util.List;

public class PopulationGeneratorService {

    protected SolutionGeneratorService solutionGeneratorService;

    public PopulationGeneratorService() {
        this.solutionGeneratorService = new SolutionGeneratorService();
    }

    public Population generatePopulation(int size, Function function) {
        List<Solution> solutionList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            solutionList.add(solutionGeneratorService.getRandom(function));
        }
        return new Population(solutionList);
    }
}
