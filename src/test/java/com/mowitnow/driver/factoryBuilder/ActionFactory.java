package com.mowitnow.driver.factoryBuilder;

import com.mowitnow.driver.model.Action;

import java.util.List;
import java.util.stream.Stream;

public class ActionFactory {
  public static List<Action> actionList1() {
    return List.of(
        Action.G, Action.A, Action.G, Action.A, Action.G, Action.A, Action.G, Action.A, Action.A);
  }

  public static List<Action> actionList2() {
    return List.of(
        Action.A, Action.A, Action.D, Action.A, Action.A, Action.D, Action.A, Action.D, Action.D,
        Action.A);
  }

  public static Stream<String> actionWrongLineValues() {
    return Stream.of("", " ", "AZDB", "AGDGDGDGlGD", "  AGDGD", "AGD ", "NSEO", "AG D", "AGDD_DAA");
  }

  public static Stream<String> actionCorrectLineValues() {
    return Stream.of("AAGDGDGADGDAGAD", "AAAAAAAA", "DDDDDDD", "GGGGG", "AAAGGDDADAAD");
  }
}
