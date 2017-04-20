package com.min.genetic.algorithm.population;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.SolutionTranslatorService;
import com.min.hillclimbing.solution.Solution;

public class PopulationBestIndividualSelectorService {

    protected SolutionTranslatorService translatorService;

    public PopulationBestIndividualSelectorService() {
        this.translatorService = new SolutionTranslatorService();
    }

    public Solution getBestIndividualFrom(Population population, Function function) {
        double besValue = Double.MAX_VALUE;
        Solution bestIndividual = null;
        for (int i = 0; i < population.getSolutions().size(); i++) {
            double[] translatedSolution = translatorService.translate(population.getSolutions().get(i), function);
            double individualValue = function.evaluateFor(translatedSolution);
            if (individualValue < besValue) {
                besValue = individualValue;
                bestIndividual = population.getSolutions().get(i);
            }
        }
        return bestIndividual;
    }
}
