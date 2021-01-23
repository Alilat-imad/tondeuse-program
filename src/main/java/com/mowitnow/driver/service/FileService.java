package com.mowitnow.driver.service;

import java.util.List;
import java.util.Optional;

public interface FileService {

  Optional<String> searchInstructionFilePath();

  List<String> readInstructionFile(String absolutePath);
}
