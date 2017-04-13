package com.min.hillclimbing.function;

import static com.google.common.math.DoubleMath.log2;
import static java.lang.Math.pow;

public class Math {

  public int computeBitsNumberForInterval(double lowerBound, double upperBound) {
    return (int)(log2(pow(10, 2) * (upperBound - lowerBound)));
  }
}
