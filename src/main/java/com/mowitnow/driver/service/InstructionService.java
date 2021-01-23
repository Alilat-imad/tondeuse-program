package com.mowitnow.driver.service;

import com.mowitnow.driver.model.*;

import java.util.List;

public interface InstructionService {
  Instruction readInstructionFile(List<String> fileContentList);

  void executeInstructionFile(Instruction instruction);

  void executeTondeuse(Tondeuse tondeuse, Terrain terrain);

  void executeAction(Terrain terrain, Position position, Action action);
}
