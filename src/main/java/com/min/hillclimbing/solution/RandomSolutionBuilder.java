package com.min.hillclimbing.solution;

import java.util.Random;

public class RandomSolutionBuilder {

  public Solution randomSolutionOfSize(int size, int sizeOfEachElement) {
    Random random = new Random();
    int[][] solution = new int[size][sizeOfEachElement];
    for(int i = 0; i<size; i++) {
      for (int j = 0; j<sizeOfEachElement; j++) {
        solution[i][j] = random.nextInt(2);
      }
    }
    return new Solution(size, sizeOfEachElement, solution);
  }
}
