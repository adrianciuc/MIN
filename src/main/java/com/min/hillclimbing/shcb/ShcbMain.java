package com.min.hillclimbing.shcb;

import com.min.hillclimbing.HillClimbing;
import com.min.hillclimbing.function.Shcb;

public class ShcbMain {

    public static void main(String[] args) {
        HillClimbing hillClimbing;
        for (int i = 0; i < 30; i++) {
            hillClimbing = new ShcbHillClimbing(new Shcb(-3, 3, -2, 2, 1), 200);
            System.out.println("Result at iteration " + (i + 1) + " : " + hillClimbing.run().getResult());
        }
    }
}
