package com.min.hillclimbing.function

import com.min.hillclimbing.solution.Solution
import spock.lang.Specification


class SolutionTranslatorServiceSpec extends Specification {

    def solution = Mock(Solution)
    def function = Mock(Function)

    def "should translate"() {
        given:
            def translator = new SolutionTranslatorService()
        when:
            double[] translated = translator.translate(solution, function)
        then:
            1 * solution.representation >> [[0,0,1,0,1,1,1,1,0,0]]
            1 * function.lowerBound >> -5.12
            1 * function.upperBound >> 5.12
            translated.length == 1
            translated[0] == -3.2381622678396873
    }
}
