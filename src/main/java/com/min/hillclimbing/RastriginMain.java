package com.min.hillclimbing;

import com.min.hillclimbing.function.Rastrigin;

public class RastriginMain {

    public static void main(String[] args) {
        HillClimbing hillClimbing;
        for (int i = 0; i < 30; i++) {
            hillClimbing = new HillClimbing(new Rastrigin(-5.12, 5.12, 30), 200);
            System.out.println("Result at iteration " + (i + 1) + " : " + hillClimbing.run().getResult());
        }
    }
}
