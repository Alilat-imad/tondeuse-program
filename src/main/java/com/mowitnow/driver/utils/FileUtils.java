package com.mowitnow.driver.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileUtils {

  public static File searchFileFromBasePath(String basePath, String fileName) {
    File f = new File(basePath);
    if (fileName.equalsIgnoreCase(f.getName())) return f;
    if (f.isDirectory()) {
      for (String aChild : f.list()) {
        File ff = searchFileFromBasePath(basePath + File.separator + aChild, fileName);
        if (ff != null) {
          return ff;
        }
      }
    }
    return null;
  }
}
