package com.min.hillclimbing.solution

import spock.lang.Specification


class HammingNeighboursServiceSpec extends Specification {

    def "should generate all hamming neighbours"() {
        given:
            int[][] representation = [[1,0]]
            def solution = new Solution(1, 2, representation)
            def service = new HammingNeighboursService()
        when:
            List<Solution> neighbours = service.getHammingNeighboursOf(solution)
        then:
            neighbours.size() == 2
            neighbours[0].representation.length == 1
            neighbours[0].representation[0].length == 2
            neighbours[0].representation[0][0] == 0
            neighbours[0].representation[0][1] == 0
            neighbours[1].representation.length == 1
            neighbours[1].representation[0].length == 2
            neighbours[1].representation[0][0] == 1
            neighbours[1].representation[0][1] == 1
    }
}
