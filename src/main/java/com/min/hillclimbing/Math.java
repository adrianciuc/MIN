package com.min.hillclimbing;

import static java.lang.Math.log;
import static java.lang.Math.pow;

class Math {

  int computeBitsNumberForInterval(double lowerBound, double upperBound) {
    return (int)(log2(pow(10, 2) * (upperBound - lowerBound)));
  }

  private double log2(double number) {
    return log(number) / log(2);
  }
}
