package com.min.hillclimbing;

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
