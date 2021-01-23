package com.mowitnow.driver.shared;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constant {
  public static final String INSTRUCTION_BASE_PATH_URL =
      "C:\\Coding Projects\\driver\\src\\main\\resources";

  public static final String INSTRUCTION_FILENAME = "instruction.txt";
  public static final String REGEX_TERRAIN_DIMENSION = "(^[1-9][0-9]*)(\\s)([1-9][0-9]*$)";
  public static final String REGEX_ACTION = "^[AGD]+$";
  public static final String REGEX_POSITION = "(^[1-9][0-9]*)(\\s)([1-9][0-9]*)(\\s)([NESO]$)";

  public static final String SEPARATOR_TERRAIN_DIMENSION = " ";
  public static final String SEPARATOR_POSITION = " ";
}
