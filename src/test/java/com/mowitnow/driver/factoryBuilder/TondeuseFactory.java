package com.mowitnow.driver.factoryBuilder;

import com.mowitnow.driver.model.Tondeuse;

import java.util.List;

public class TondeuseFactory {

  public static Tondeuse.TondeuseBuilder tondeuse_1() {
    return Tondeuse.builder()
        .id(1)
        .position(PositionFactory.position_1().build())
        .actionList(ActionFactory.actionList1());
  }

  public static Tondeuse.TondeuseBuilder tondeuse_2() {
    return Tondeuse.builder()
        .id(2)
        .position(PositionFactory.position_2().build())
        .actionList(ActionFactory.actionList2());
  }

  public static List<Tondeuse> tondeuseList() {
    return List.of(tondeuse_1().build(), tondeuse_2().build());
  }
}
