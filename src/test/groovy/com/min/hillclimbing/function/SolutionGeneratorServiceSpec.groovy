package com.min.hillclimbing.function

import spock.lang.Specification


class SolutionGeneratorServiceSpec extends Specification {

    def "should generate a solution for a function"() {
        given:
            def service = new SolutionGeneratorService()
            def function = Mock(Function)
        when:
            def solution = service.getRandom(function)
        then:
            1 * function.lowerBound >> -5.12
            1 * function.upperBound >> 5.12
            1 * function.numberOfElementsInSolution >> 5
            solution.representation.length == 5
            solution.representation.each {
                assert it.length == 10
                it.each {
                    it == 0 || it == 1
                }
            }
    }
}
