package com.min.hillclimbing;

import com.min.hillclimbing.function.Function;
import com.min.hillclimbing.solution.RandomSolutionBuilder;
import com.min.hillclimbing.solution.Solution;

public class HillClimbing {

  private final Function function;
  private final RandomSolutionBuilder builder;

  HillClimbing(Function function) {
    this.function = function;
    this.builder = new RandomSolutionBuilder();
  }

  public void run() {
    Solution firstSolution =
            builder.randomSolutionOfSize(
                    function.getNumberOfElementsInSolution(),
                    function.getSizeOfElementInSolution());
  }
}
