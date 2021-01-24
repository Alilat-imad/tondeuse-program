package com.mowitnow.driver.factoryBuilder;

import com.mowitnow.driver.model.Terrain;

import java.util.stream.Stream;

public class TerrainFactory {

  public static Stream<String> terrainCorrectLineValues() {
    return Stream.of("5 5", "8 8", "4 50", "10 4", "40 50", "300 555");
  }

  public static Stream<String> terrainWrongLineValues() {
    return Stream.of("", " ", "5 5 ", " 5 5 ", "5 0", "5 a", "a 4", "0 5", "0 0", "a a", "55");
  }

  public static Terrain.TerrainBuilder terrain_5x5() {
    return Terrain.builder().width(5).length(5);
  }
}
