package com.mowitnow.driver.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Action {
  D("TOURNER_DROITE"),
  G("TOURNER_GAUCHE"),
  A("AVANCER");

  private final String label;
}
