package com.mowitnow.driver.utils;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.mowitnow.driver.shared.Constant.INSTRUCTION_BASE_PATH_URL;
import static com.mowitnow.driver.shared.Constant.INSTRUCTION_FILENAME;
import static org.assertj.core.api.Assertions.assertThat;

class FileUtilsTest {

  @Test
  void searchFileFromBasePath() {
    // Given
    File expectedFile =
        new File("C:\\Coding Projects\\driver\\src\\main\\resources\\instruction.txt");
    // When
    File actual = FileUtils.searchFileFromBasePath(INSTRUCTION_BASE_PATH_URL, INSTRUCTION_FILENAME);
    // Then
    assertThat(actual).exists().isFile().isEqualTo(expectedFile);
  }
}
