package com.min.genetic.algorithm.population;

import com.min.hillclimbing.solution.Solution;
import com.sun.org.apache.bcel.internal.generic.POP;

import java.util.List;

public class Population {

    List<Solution> solutions;

    public Population(List<Solution> solutions) {
        this.solutions = solutions;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}
