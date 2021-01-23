package com.mowitnow.driver.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static com.mowitnow.driver.shared.Constant.INSTRUCTION_BASE_PATH_URL;
import static com.mowitnow.driver.shared.Constant.INSTRUCTION_FILENAME;
import static com.mowitnow.driver.shared.Message.FICHIER_INSTRUCTION_VIDE;
import static com.mowitnow.driver.utils.FileUtils.searchFileFromBasePath;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

  @Override
  public Optional<String> searchInstructionFilePath() {
    File file = searchFileFromBasePath(INSTRUCTION_BASE_PATH_URL, INSTRUCTION_FILENAME);
    if (file == null) return Optional.empty();
    return Optional.of(file.getAbsolutePath());
  }

  @SneakyThrows
  @Override
  public List<String> readInstructionFile(String absolutePath) {
    List<String> fileContentList = Files.readAllLines(Paths.get(absolutePath));
    if (fileContentList.isEmpty() || fileContentList.size() < 3) {
      log.error("Exception : reading instruction file.");
      throw new IllegalArgumentException(FICHIER_INSTRUCTION_VIDE + absolutePath);
    }
    return fileContentList;
  }
}
