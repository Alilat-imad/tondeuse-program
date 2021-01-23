package com.mowitnow.driver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class Instruction {
  private Terrain terrain;
  private List<Tondeuse> tondeuseList;
}
