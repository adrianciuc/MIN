package com.min.hillclimbing.solution

import com.min.hillclimbing.function.Rastrigin
import com.min.hillclimbing.function.SolutionTranslatorService
import spock.lang.Specification


class BinaryToIntegerTranslatorSpec extends Specification {

    def "should translate binary array to double array"() {
        given:
        def service = new SolutionTranslatorService()
        when:
        double[] translated = service.translate(
                getSolution(),
                new Rastrigin(-5.12, 5.12, 5))
        then:
        translated.length == 5
        translated[0] == -3.2381622678396873
        translated[1] == 0.265259042033235
        translated[2] == -3.89880742913001
        translated[3] == 0.7257086999022491
        translated[4] == 2.3472922776148586
    }

    private static Solution getSolution() {
        int[][] representation = [[0,0,1,0,1,1,1,1,0,0],
                                  [1,0,0,0,0,1,1,0,1,0],
                                  [0,0,0,1,1,1,1,0,1,1],
                                  [1,0,0,1,0,0,1,0,0,1],
                                  [1,0,1,1,1,0,1,0,1,0]]
        return new Solution(5, 10,representation)
    }
}
