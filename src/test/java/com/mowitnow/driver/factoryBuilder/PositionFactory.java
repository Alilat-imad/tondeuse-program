package com.mowitnow.driver.factoryBuilder;

import com.mowitnow.driver.model.Orientation;
import com.mowitnow.driver.model.Position;

import java.util.stream.Stream;

public class PositionFactory {

  public static Position.PositionBuilder position_1() {
    return Position.builder().x(1).y(2).orientation(Orientation.N);
  }

  public static Position.PositionBuilder position_2() {
    return Position.builder().x(3).y(3).orientation(Orientation.E);
  }

  public static Stream<String> positionCorrectLineValues() {
    return Stream.of("1 3 N", "1 3 E", "5 4 O", "5 4 O", "9 1 E", "4 1 S");
  }

  public static Stream<String> positionWrongLineValues() {
    return Stream.of("", " ", "1 a N", "1 4 Z", " 1 2 N", "5 5", "4 5 E ", "4 9 C ", "1 5");
  }
}
