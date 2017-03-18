package com.min.hillclimbing

import spock.lang.Specification


class RandomSolutionBuilderSpec extends Specification {

    def "should generate solutions only with 1 and 0"() {
        given:
            RandomSolutionBuilder builder = new RandomSolutionBuilder()
        when:
            Solution solution = builder.randomSolutionOfSize(5, 10)
        then:
            solution.size == 5
            solution.sizeOfEachElement == 10
            solution.representation.length == 5
            0..4.each {
                assert solution.representation[it].length == 10
                solution.representation[it].each {
                    assert it == 0 || it == 1
                }
            }
    }
}
