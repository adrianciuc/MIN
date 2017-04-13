package com.min.hillclimbing.shcb;

import com.min.hillclimbing.HillClimbing;
import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.shcb.ShcbSolutionGeneratorService;
import com.min.hillclimbing.function.shcb.ShcbSolutionTranslatorService;
import com.min.hillclimbing.solution.shcb.ShcbHammingNeighboursService;

public class ShcbHillClimbing extends HillClimbing {


    public ShcbHillClimbing(Function function, Integer iterations) {
        super(function, iterations);
        this.solutionService = new ShcbSolutionGeneratorService();
        this.solutionTranslatorService = new ShcbSolutionTranslatorService();
        this.hammingNeighboursService = new ShcbHammingNeighboursService();
    }
}
