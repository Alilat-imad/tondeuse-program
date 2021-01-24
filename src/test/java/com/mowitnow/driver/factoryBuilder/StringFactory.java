package com.mowitnow.driver.factoryBuilder;

import java.util.List;
import java.util.stream.Stream;

public class StringFactory {

  public static Stream<String> blank_empty_null_Strings() {
    return Stream.of("              ", "  ", "", null);
  }

  public static List<String> instruction_file_as_String_Array() {
    return List.of("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
  }

  public static String instruction_file_absolute_path() {
    return "C:\\Coding Projects\\driver\\src\\test\\resources\\instruction.txt";
  }

  public static Stream<String> instruction_files_absolute_path() {
    return Stream.of(
        "C:\\Coding Projects\\driver\\src\\test\\resources\\instruction-test1.txt",
        "C:\\Coding Projects\\driver\\src\\test\\resources\\instruction-test2.txt",
        "C:\\Coding Projects\\driver\\src\\test\\resources\\instruction-test3.txt");
  }
}
