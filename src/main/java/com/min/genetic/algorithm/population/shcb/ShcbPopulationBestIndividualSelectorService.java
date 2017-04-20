package com.min.genetic.algorithm.population.shcb;

import com.min.genetic.algorithm.population.PopulationBestIndividualSelectorService;
import com.min.hillclimbing.function.shcb.ShcbSolutionTranslatorService;

public class ShcbPopulationBestIndividualSelectorService extends PopulationBestIndividualSelectorService {

    public ShcbPopulationBestIndividualSelectorService() {
        this.translatorService = new ShcbSolutionTranslatorService();
    }
}
