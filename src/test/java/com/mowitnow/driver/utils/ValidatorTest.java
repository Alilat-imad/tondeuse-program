package com.mowitnow.driver.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.mowitnow.driver.shared.Constant.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ValidatorTest {

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.StringFactory#blank_empty_null_Strings")
  void isNullOrEmpty_when_havingBlankEmptyOrNullLine_shouldReturnFalse(String input) {
    // when
    boolean expected = Validator.isNullOrEmpty(input);

    // then
    assertThat(expected).isTrue();
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.TerrainFactory#terrainCorrectLineValues")
  void isInvalidLine_WhenHavingRegexOfTerrainWithCorrectValues(String input) {
    // when
    boolean expected = Validator.isInvalidLine(input, REGEX_TERRAIN_DIMENSION);

    // then
    assertThat(expected).isFalse();
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.TerrainFactory#terrainWrongLineValues")
  void isInvalidLine_WhenHavingRegexOfTerrainWithWrongValues(String input) {
    // when
    boolean expected = Validator.isInvalidLine(input, REGEX_TERRAIN_DIMENSION);

    // then
    assertThat(expected).isTrue();
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.PositionFactory#positionCorrectLineValues")
  void isInvalidLine_WhenHavingRegexOfPositionWithCorrectValue(String input) {
    // when
    boolean expected = Validator.isInvalidLine(input, REGEX_POSITION);

    // then
    assertThat(expected).isFalse();
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.PositionFactory#positionWrongLineValues")
  void isInvalidLine_WhenHavingRegexOfPositionWithWrongValues(String input) {
    // when
    boolean expected = Validator.isInvalidLine(input, REGEX_POSITION);

    // then
    assertThat(expected).isTrue();
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.ActionFactory#actionCorrectLineValues")
  void isInvalidLine_WhenHavingRegexOfActionWithCorrectValue(String input) {
    // when
    boolean expected = Validator.isInvalidLine(input, REGEX_ACTION);

    // then
    assertThat(expected).isFalse();
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.ActionFactory#actionWrongLineValues")
  void isInvalidLine_WhenHavingRegexOfActionWithWrongValues(String input) {
    // when
    boolean expected = Validator.isInvalidLine(input, REGEX_ACTION);

    // then
    assertThat(expected).isTrue();
  }
}
