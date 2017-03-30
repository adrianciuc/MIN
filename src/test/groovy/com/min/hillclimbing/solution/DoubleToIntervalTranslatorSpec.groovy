package com.min.hillclimbing.solution

import spock.lang.Specification


class DoubleToIntervalTranslatorSpec extends Specification {

    def "should translate #number in interval #lowerBound - #upperBound"() {
        given:
            def translator = new DoubleToIntervalTranslator()
        when:
            double[] numbers = number.toArray().collect {(double)it}
            def translation = translator.translate(numbers, lowerBound.doubleValue(), upperBound.doubleValue())
        then:
            translation[0] >= lowerBound
            translation[0] <= upperBound
        where:
            number    |   lowerBound  |   upperBound
            [2000]    |   -5.12       |   5.12
    }
}
