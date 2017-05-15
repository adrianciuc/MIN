package com.min.genetic.algorithm.population.shcb;

import com.min.genetic.algorithm.population.PopulationCrossoverService;
import com.min.hillclimbing.solution.Solution;
import com.min.hillclimbing.solution.shcb.ShcbSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.min.Utils.coppy;

public class ShcbPopulationCrossoverService extends PopulationCrossoverService {

    public ShcbPopulationCrossoverService(double crossoverProbability) {
        super(crossoverProbability);
    }

    protected List<Solution> crossoverIndividuals(Solution firstSolution, Solution secondSolution) {
        List<Solution> crossoverIndividuals = new ArrayList<>();
        Random random = new Random();
        if (!random.nextBoolean()) {
            int[][] aux = coppy(firstSolution.getRepresentation().length,
                    firstSolution.getRepresentation()[0].length,
                    firstSolution.getRepresentation());
            int[][] auxPrim = coppy(((ShcbSolution)firstSolution).getSecondRepresentation().length,
                    ((ShcbSolution)firstSolution).getSecondRepresentation()[0].length,
                    ((ShcbSolution)firstSolution).getSecondRepresentation());
            firstSolution.setRepresentation(coppy(secondSolution.getRepresentation().length,
                    secondSolution.getRepresentation()[0].length,
                    secondSolution.getRepresentation()));
            ((ShcbSolution)firstSolution).setSecondRepresentation(
                    coppy(((ShcbSolution)secondSolution).getSecondRepresentation().length,
                            ((ShcbSolution)secondSolution).getSecondRepresentation()[0].length,
                            ((ShcbSolution)secondSolution).getSecondRepresentation()));
            secondSolution.setRepresentation(aux);
            ((ShcbSolution)secondSolution).setSecondRepresentation(auxPrim);
        }
        int chromosomeToCross = random.nextInt(2);
        int[][] crossedChromosomes;
        if (chromosomeToCross == 0) {
            crossedChromosomes = cross(firstSolution.getRepresentation()[0],
                    secondSolution.getRepresentation()[0]);
            firstSolution.getRepresentation()[0] = crossedChromosomes[0];
            secondSolution.getRepresentation()[0] = crossedChromosomes[1];
        } else {
            crossedChromosomes = cross(((ShcbSolution)firstSolution).getSecondRepresentation()[0],
                    ((ShcbSolution)secondSolution).getSecondRepresentation()[0]);
            ((ShcbSolution)firstSolution).getSecondRepresentation()[0] = crossedChromosomes[0];
            ((ShcbSolution)secondSolution).getSecondRepresentation()[0] = crossedChromosomes[1];
        }
        crossoverIndividuals.add(firstSolution);
        crossoverIndividuals.add(secondSolution);
        return crossoverIndividuals;
    }
}
