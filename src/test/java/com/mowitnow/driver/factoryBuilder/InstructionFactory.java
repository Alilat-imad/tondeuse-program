package com.mowitnow.driver.factoryBuilder;

import com.mowitnow.driver.model.Instruction;

public class InstructionFactory {

  public static Instruction.InstructionBuilder instruction() {
    return Instruction.builder()
        .tondeuseList(TondeuseFactory.tondeuseList())
        .terrain(TerrainFactory.terrain_5x5().build());
  }
}
