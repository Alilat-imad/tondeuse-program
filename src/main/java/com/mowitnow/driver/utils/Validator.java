package com.mowitnow.driver.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Validator {

  public static boolean isNullOrEmpty(String line) {
    return (line == null || line.isBlank());
  }

  public static boolean isInvalidLine(String line, String regex) {
    return (!line.matches(regex));
  }
}
