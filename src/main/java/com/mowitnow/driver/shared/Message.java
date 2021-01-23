package com.mowitnow.driver.shared;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Message {
  public static final String EXCEPTION_MISSING_TERRAIN_DIMENSION =
      "Exception : Missing terrain dimension";
  public static final String EXCEPTION_INVALID_TERRAIN_DIMENSION =
      "Exception : Invalid terrain dimension";

  public static final String EXCEPTION_MISSING_POSITION = "Exception : Missing position";
  public static final String EXCEPTION_INVALID_POSITION = "Exception : Invalid position";

  public static final String EXCEPTION_MISSING_ACTION = "Exception : Missing action";
  public static final String EXCEPTION_INVALID_ACTION = "Exception : Invalid action";

  public static final String FICHIER_INSTRUCTION_VIDE = "ERROR : Le fichier 'Instruction'  est vide | Path  : ";

}
