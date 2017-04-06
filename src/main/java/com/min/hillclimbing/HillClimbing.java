package com.min.hillclimbing;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.function.SolutionGeneratorService;

public class HillClimbing {

  private final Function function;
  private final SolutionGeneratorService solutionService;

  HillClimbing(Function function) {
    this.function = function;
    solutionService = new SolutionGeneratorService();
  }

  public void run() {
    Solution firstSolution = solutionService.getRandom(function);
  }
}
