package com.min.hillclimbing.solution

import spock.lang.Specification


class IntegerToDoubleIntervalTranslatorSpec extends Specification {

    def "should translate #number in interval #lowerBound - #upperBound"() {
        given:
            def translator = new IntegerToDoubleIntervalTranslator()
        when:
            int[] numbers = number.toArray().collect {(int)it}
            def translation = translator.translate(numbers, lowerBound.doubleValue(), upperBound.doubleValue())
        then:
            translation[0] == expectedTranslation.doubleValue()
            translation[0] >= lowerBound
            translation[0] <= upperBound
        where:
            number      |   lowerBound  |   upperBound  | expectedTranslation
            [714]       |   -5.12       |   5.12        | 2.026979472140763
    }
}
