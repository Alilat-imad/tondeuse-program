package com.mowitnow.driver.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Orientation {
  N("NORD"),
  E("EST"),
  S("SUD"),
  O("OUEST");

  private final String label;

  private static final Orientation[] orientations = values();

  public static int length() {
    return orientations.length;
  }

  public Orientation nextOrientation() {
    int next = ordinal() + 1;
    return orientations[next % length()];
  }

  public Orientation prevOrientation() {
    int previous = ordinal() - 1;
    return orientations[(previous < 0) ? (previous + length()) : previous];
  }
}
