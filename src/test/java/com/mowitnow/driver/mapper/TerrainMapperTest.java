package com.mowitnow.driver.mapper;

import com.mowitnow.driver.factoryBuilder.TerrainFactory;
import com.mowitnow.driver.model.Terrain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TerrainMapperTest {

  @Test
  void parseFromLine_WhenHavingRegexOfTerrain() {
    // given
    Terrain expectedResult = TerrainFactory.terrain_5x5().build();
    String input = "5 5";

    // when
    Terrain actual = TerrainMapper.parseFromLine(input);

    // then
    assertThat(actual).isNotNull();
    assertThat(actual).usingRecursiveComparison().isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.TerrainFactory#terrainWrongLineValues")
  void parseFromLine_WhenHavingWrongValues_ShouldThrowException(String input) {
    org.junit.jupiter.api.Assertions.assertThrows(
        IllegalArgumentException.class, () -> TerrainMapper.parseFromLine(input));
  }
}
