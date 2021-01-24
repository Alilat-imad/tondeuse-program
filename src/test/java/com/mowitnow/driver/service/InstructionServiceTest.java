package com.mowitnow.driver.service;

import com.mowitnow.driver.factoryBuilder.InstructionFactory;
import com.mowitnow.driver.factoryBuilder.StringFactory;
import com.mowitnow.driver.model.Instruction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionServiceTest {

  InstructionService instructionService = new InstructionServiceImpl();

  @Test
  void readInstructionFile() {
    // Given
    List<String> input = StringFactory.instruction_file_as_String_Array();
    Instruction expectedInstruction = InstructionFactory.instruction().build();

    // When
    Instruction actualInstruction = instructionService.readInstructionFile(input);

    // then
    assertThat(actualInstruction).isNotNull();
    assertThat(actualInstruction).usingRecursiveComparison().isEqualTo(expectedInstruction);
  }

  // TODO
  @Test
  void executeInstructionFile() {
    // Given

    // When

    // then
  }

  // TODO
  @Test
  void executeTondeuse() {
    // Given

    // When

    // then
  }
}
