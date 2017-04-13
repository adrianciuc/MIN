package com.min.hillclimbing;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.function.SolutionTranslatorService;
import com.min.hillclimbing.solution.HammingNeighboursService;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.function.SolutionGeneratorService;
import com.min.hillclimbing.solution.SolutionResult;

import java.util.List;

import static java.util.Collections.shuffle;
import static java.util.stream.IntStream.range;

public class HillClimbing {

  protected Function function;
  protected Integer iterations;
  protected SolutionGeneratorService solutionService;
  protected SolutionTranslatorService solutionTranslatorService;
  protected HammingNeighboursService hammingNeighboursService;

  protected HillClimbing(Function function, Integer iterations) {
    this.iterations = iterations;
    this.function = function;
    this.solutionService = new SolutionGeneratorService();
    this.solutionTranslatorService = new SolutionTranslatorService();
    this.hammingNeighboursService = new HammingNeighboursService();
  }

  public SolutionResult run() {
    Solution solutionToTry = solutionService.getRandom(function);
    SolutionResult solutionResult = null;
    for (int i = 0; i < iterations; i++) {
      solutionResult = findGlobalMin(solutionToTry);
      solutionToTry = solutionResult.getSolution();
    }
    return solutionResult;
  }

  private SolutionResult findGlobalMin(Solution initialSolution) {
    Solution solutionToEvaluate = initialSolution;
    double[] solutionTranslation = solutionTranslatorService.translate(solutionToEvaluate, function);
    double solutionResult = function.evaluateFor(solutionTranslation);
    List<Solution> hammingNeighbours = hammingNeighboursService.getHammingNeighboursOf(solutionToEvaluate);
    shuffle(hammingNeighbours);
    for (Solution hammingNeighbour : hammingNeighbours) {
      double[] neighbourTranslation = solutionTranslatorService.translate(hammingNeighbour, function);
      double neighbourResult = function.evaluateFor(neighbourTranslation);
      if (neighbourResult < solutionResult) {
        solutionResult = neighbourResult;
        solutionToEvaluate = hammingNeighbour;
        break;
      }
    }
    return new SolutionResult(solutionToEvaluate, solutionResult);
  }
}
