package com.min.hillclimbing;

import com.min.hillclimbing.function.Griewangk;

public class GriewangkMain {

    public static void main(String[] args) {
        HillClimbing hillClimbing;
        for (int i = 0; i < 30; i++) {
            hillClimbing = new HillClimbing(new Griewangk(-600, 600, 30), 200);
            System.out.println("Result at iteration " + (i + 1) + " : " + hillClimbing.run().getResult());
        }
    }
}
