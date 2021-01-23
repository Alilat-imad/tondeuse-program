package com.mowitnow.driver;

import com.mowitnow.driver.model.Instruction;
import com.mowitnow.driver.service.FileService;
import com.mowitnow.driver.service.InstructionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class DriverApplication implements CommandLineRunner {

  private final InstructionService instructionService;
  private final FileService fileService;

  public static void main(String[] args) {
    SpringApplication.run(DriverApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    var instructionFilePath = this.fileService.searchInstructionFilePath();
    if (instructionFilePath.isEmpty()) log.error("Error : File not found.");
    else {
      List<String> fileContent = this.fileService.readInstructionFile(instructionFilePath.get());
      Instruction instruction = this.instructionService.readInstructionFile(fileContent);
      this.instructionService.executeInstructionFile(instruction);
    }
  }
}
