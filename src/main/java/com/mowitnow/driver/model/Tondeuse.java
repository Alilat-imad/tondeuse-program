package com.mowitnow.driver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class Tondeuse {
  private Integer id;
  private Position position;
  private List<Action> actionList;
}
