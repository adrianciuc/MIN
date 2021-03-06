package com.min.hillclimbing;

import com.min.hillclimbing.function.Rosenbrock;

public class RosenbrockMain {

    public static void main(String[] args) {
        HillClimbing hillClimbing;
        for (int i = 0; i < 30; i++) {
            hillClimbing = new HillClimbing(new Rosenbrock(-2.048, 2.048, 30), 200);
            System.out.println("Result at iteration " + (i + 1) + " : " + hillClimbing.run().getResult());
        }
    }
}
