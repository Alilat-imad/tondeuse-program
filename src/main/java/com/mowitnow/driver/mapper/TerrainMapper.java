package com.mowitnow.driver.mapper;

import com.mowitnow.driver.model.Terrain;
import com.mowitnow.driver.utils.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.mowitnow.driver.shared.Constant.REGEX_TERRAIN_DIMENSION;
import static com.mowitnow.driver.shared.Constant.SEPARATOR_TERRAIN_DIMENSION;
import static com.mowitnow.driver.shared.Message.EXCEPTION_INVALID_TERRAIN_DIMENSION;
import static com.mowitnow.driver.shared.Message.EXCEPTION_MISSING_TERRAIN_DIMENSION;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TerrainMapper {

  public static Terrain parseFromLine(String line) {
    if (Validator.isNullOrEmpty(line))
      throw new IllegalArgumentException(EXCEPTION_MISSING_TERRAIN_DIMENSION);
        if (Validator.isInvalidLine(line, REGEX_TERRAIN_DIMENSION))
          throw new IllegalArgumentException(EXCEPTION_INVALID_TERRAIN_DIMENSION);
    String[] dimension = line.split(SEPARATOR_TERRAIN_DIMENSION);

    int dimX = Integer.parseInt(dimension[0]);
    int dimY = Integer.parseInt(dimension[1]);

    return Terrain.builder().width(dimX).length(dimY).build();
  }
}
