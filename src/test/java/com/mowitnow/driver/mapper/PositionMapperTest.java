package com.mowitnow.driver.mapper;

import com.mowitnow.driver.factoryBuilder.PositionFactory;
import com.mowitnow.driver.model.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionMapperTest {

  @Test
  void parseFromLine_WhenHavingRegexOfPosition_1() {
    // given
    Position expectedResult = PositionFactory.position_1().build();
    String input = "1 2 N";

    // when
    Position actual = PositionMapper.parseFromLine(input);

    // then
    assertThat(actual).isNotNull();
    assertThat(actual).usingRecursiveComparison().isEqualTo(expectedResult);
  }

  @Test
  void parseFromLine_WhenHavingRegexOfPosition_2() {
    // given
    Position expectedResult = PositionFactory.position_2().build();
    String input = "3 3 E";

    // when
    Position actual = PositionMapper.parseFromLine(input);

    // then
    assertThat(actual).isNotNull();
    assertThat(actual).usingRecursiveComparison().isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.PositionFactory#positionWrongLineValues")
  void parseFromLine_WhenHavingWrongValues_ShouldThrowException(String input) {
    org.junit.jupiter.api.Assertions.assertThrows(
        IllegalArgumentException.class, () -> PositionMapper.parseFromLine(input));
  }
}
