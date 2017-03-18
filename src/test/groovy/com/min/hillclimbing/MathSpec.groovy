package com.min.hillclimbing

import spock.lang.Specification
import spock.lang.Unroll

class MathSpec extends Specification {

  def math = new Math()

  @Unroll
  def "interval #lowerBound - #upperBound should have #number"() {
    expect:
      number == math.computeBitsNumberForInterval(lowerBound, upperBound)
    where:
      lowerBound  | upperBound  | number
      -5.12       | 5.12        | 10
  }
}
