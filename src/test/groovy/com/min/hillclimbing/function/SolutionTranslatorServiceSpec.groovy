package com.min.hillclimbing.function

import com.min.hillclimbing.solution.BinaryToIntegerTranslator
import com.min.hillclimbing.solution.IntegerToDoubleIntervalTranslator
import com.min.hillclimbing.solution.Solution
import spock.lang.Specification


class SolutionTranslatorServiceSpec extends Specification {

    def binaryToInteger = Mock(BinaryToIntegerTranslator)
    def integerToDoubleInterval = Mock(IntegerToDoubleIntervalTranslator)
    def solution = Mock(Solution)
    def function = Mock(Function)

    def "should translate"() {
        given:
            def translator = new SolutionTranslatorService(binaryToInteger, integerToDoubleInterval)
        when:
            double[] translated = translator.translate(solution, function)
        then:
            1 * solution.representation >> [1011001010]
            1 * binaryToInteger.translate([1011001010]) >> [714]
            1 * function.lowerBound >> -5.12
            1 * function.upperBound >> 5.12
            1 * integerToDoubleInterval.translate([714], -5.12, 5.12) >> 2.026979472140763
            translated.length == 1
            translated[0] == 2.026979472140763
    }
}
