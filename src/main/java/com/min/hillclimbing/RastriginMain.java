package com.min.hillclimbing;

import com.min.hillclimbing.function.Rastrigin;

public class RastriginMain {

    public static void main(String[] args) {
        HillClimbing hillClimbing;

            hillClimbing = new HillClimbing(new Rastrigin(-5.12, 5.12, 30), 200);
        hillClimbing.run();
//            System.out.println("Result at iteration " + (i + 1) + " : " + .getResult());

    }
}
