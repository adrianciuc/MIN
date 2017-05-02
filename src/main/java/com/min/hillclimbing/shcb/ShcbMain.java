package com.min.hillclimbing.shcb;

import com.min.hillclimbing.HillClimbing;
import com.min.hillclimbing.function.Shcb;

public class ShcbMain {

    public static void main(String[] args) {
        HillClimbing hillClimbing;

            hillClimbing = new ShcbHillClimbing(new Shcb(-3, 3, -2, 2, 1), 200);
            hillClimbing.run();

    }
}
