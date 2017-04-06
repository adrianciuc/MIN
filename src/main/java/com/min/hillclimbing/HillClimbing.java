package com.min.hillclimbing;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.SolutionTranslatorService;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.function.SolutionGeneratorService;

import static java.util.stream.IntStream.range;

public class HillClimbing {

  private final Function function;
  private final Integer iterations;
  private final SolutionGeneratorService solutionService;
  private final SolutionTranslatorService solutionTranslatorService;

  HillClimbing(Function function, Integer iterations) {
    this.iterations = iterations;
    this.function = function;
    this.solutionService = new SolutionGeneratorService();
    this.solutionTranslatorService = new SolutionTranslatorService();
  }

  public void run() {
    Solution initialSolution = solutionService.getRandom(function);
    range(0, iterations).forEach(it -> findGlobalMin(it, initialSolution));
  }

  private void findGlobalMin(Integer iteration, Solution initialSolution) {
    double[] solutionTranslation = solutionTranslatorService.translate(initialSolution, function);
    double solutionResult = function.evaluateFor(solutionTranslation);
  }
}
