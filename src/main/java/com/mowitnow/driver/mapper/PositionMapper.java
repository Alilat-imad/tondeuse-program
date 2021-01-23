package com.mowitnow.driver.mapper;

import com.mowitnow.driver.model.Orientation;
import com.mowitnow.driver.model.Position;
import com.mowitnow.driver.utils.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.mowitnow.driver.shared.Constant.REGEX_POSITION;
import static com.mowitnow.driver.shared.Constant.SEPARATOR_POSITION;
import static com.mowitnow.driver.shared.Message.EXCEPTION_INVALID_POSITION;
import static com.mowitnow.driver.shared.Message.EXCEPTION_MISSING_POSITION;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PositionMapper {

  public static Position parseFromLine(String line) {
    if (Validator.isNullOrEmpty(line))
      throw new IllegalArgumentException(EXCEPTION_MISSING_POSITION);
    if (Validator.isInvalidLine(line, REGEX_POSITION))
      throw new IllegalArgumentException(EXCEPTION_INVALID_POSITION);
    String[] dimension = line.split(SEPARATOR_POSITION);

    int dimX = Integer.parseInt(dimension[0]);
    int dimY = Integer.parseInt(dimension[1]);
    Orientation orientation = Orientation.valueOf(dimension[2]);

    return Position.builder().x(dimX).y(dimY).orientation(orientation).build();
  }
}
