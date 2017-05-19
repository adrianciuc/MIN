package com.min.hillclimbing;

import com.min.hillclimbing.function.Rastrigin;

import java.io.IOException;

import static java.nio.file.Files.write;
import static java.nio.file.Paths.get;
import static java.util.stream.IntStream.range;

public class RastriginMain {

    public static void main(String[] args) throws IOException {
        String FILE_WITH_RESULTS = "C:\\Users\\adria\\results_hill_climbing_restarted.csv";
        StringBuffer buffer = new StringBuffer();
        range(0, 15).forEach(it -> executeOneTime(buffer));
        write(get(FILE_WITH_RESULTS), buffer.toString().getBytes());
    }

    private static void executeOneTime(StringBuffer buffer) {
        HillClimbing hillClimbing = new HillClimbing(new Rastrigin(-5.12, 5.12, 30), 200);
        hillClimbing.run();
        buffer.append(hillClimbing.getBuffer().toString());
    }
}
