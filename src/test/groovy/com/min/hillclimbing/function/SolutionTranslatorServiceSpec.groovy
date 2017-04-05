package com.min.hillclimbing.function

import com.min.hillclimbing.solution.BinaryToIntegerTranslator
import com.min.hillclimbing.solution.IntegerToDoubleIntervalTranslator
import com.min.hillclimbing.solution.Solution
import spock.lang.Specification


class SolutionTranslatorServiceSpec extends Specification {

    def binaryToInteger = Stub(BinaryToIntegerTranslator)
    def integerToDoubleInterval = Stub(IntegerToDoubleIntervalTranslator)
    def solution = Stub(Solution)
    def function = Stub(Function)

    def "should translate"() {
        given:
            def translator = new SolutionTranslatorService(binaryToInteger, integerToDoubleInterval)
        when:
            double[] translated = translator.translate(solution, function)
        then:
            1 * solution.representation >> solutionRepresentation()
            1 * binaryToInteger.translate(solutionRepresentation()) >> representationToInteger()
            1 * function.lowerBound >> -5.12
            1 * function.upperBound >> 5.12
            1 * integerToDoubleInterval.translate(
                    representationToInteger(),
                    function.lowerBound,
                    function.upperBound)
    }

    int[][] solutionRepresentation() {
        int[][] representation = new int[1][2]
        representation[0] = [1,1]
        return representation
    }

    int[] representationToInteger() {
        int[] integers = new int[1]
        integers[0] = 3
        return integers
    }
}
