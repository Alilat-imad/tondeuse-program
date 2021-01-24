package com.mowitnow.driver.mapper;

import com.mowitnow.driver.factoryBuilder.ActionFactory;
import com.mowitnow.driver.model.Action;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ActionMapperTest {

  @Test
  void parseFromLine_WhenHavingRegexOfActionList1() {
    // given
    List<Action> expectedResult = ActionFactory.actionList1();
    String input = "GAGAGAGAA";

    // when
    List<Action> actual = ActionMapper.parseFromLine(input);

    // then
    assertThat(actual).isNotEmpty().hasSize(input.length());
    assertThat(actual).usingRecursiveComparison().isEqualTo(expectedResult);
  }

  @Test
  void parseFromLine_WhenHavingRegexOfActionList2() {
    // given
    List<Action> expectedResult = ActionFactory.actionList2();
    String input = "AADAADADDA";

    // when
    List<Action> actual = ActionMapper.parseFromLine(input);

    // then
    assertThat(actual).isNotEmpty().hasSize(input.length());
    assertThat(actual).usingRecursiveComparison().isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.ActionFactory#actionWrongLineValues")
  void parseFromLine_WhenHavingWrongValues_ShouldThrowException(String input) {
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> ActionMapper.parseFromLine(input));
  }
}
