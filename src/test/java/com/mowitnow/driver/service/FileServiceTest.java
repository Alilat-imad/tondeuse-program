package com.mowitnow.driver.service;

import com.mowitnow.driver.factoryBuilder.StringFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class FileServiceTest {

  FileService fileService = new FileServiceImpl();

  @Test
  void searchInstructionFilePath_shouldReturnAboslutPath() {
    // Given
    String givenAbsolutePathOfInstructionFile =
        "C:\\Coding Projects\\driver\\src\\main\\resources\\instruction.txt";
    // When
    Optional<String> expectedInstructionFilePath = fileService.searchInstructionFilePath();

    // Then
    assertThat(expectedInstructionFilePath).isPresent();
    assertThat(expectedInstructionFilePath.get()).isEqualTo(givenAbsolutePathOfInstructionFile);
  }

  @Test
  void readInstructionFile() {
    // Given
    List<String> expectedInstructionFileStringList =
        StringFactory.instruction_file_as_String_Array();
    String givenAbsolutePathOfInstructionFile = StringFactory.instruction_file_absolute_path();
    // When
    List<String> actualInstructionFileStringList =
        fileService.readInstructionFile(givenAbsolutePathOfInstructionFile);

    // Then
    assertThat(actualInstructionFileStringList).isNotEmpty();
    assertThat(actualInstructionFileStringList)
        .usingRecursiveComparison()
        .isEqualTo(expectedInstructionFileStringList);
  }

  @ParameterizedTest
  @MethodSource("com.mowitnow.driver.factoryBuilder.StringFactory#instruction_files_absolute_path")
  void readInstructionFile_shouldThrowException(String input) {

    Assertions.assertThrows(
        IllegalArgumentException.class, () -> fileService.readInstructionFile(input));
  }
}
