package com.mowitnow.driver.service;

import com.mowitnow.driver.mapper.ActionMapper;
import com.mowitnow.driver.mapper.PositionMapper;
import com.mowitnow.driver.mapper.TerrainMapper;
import com.mowitnow.driver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
@RequiredArgsConstructor
public class InstructionServiceImpl implements InstructionService {

  @SneakyThrows
  @Override
  public Instruction readInstructionFile(List<String> fileContentList) {

    List<Tondeuse> tondeuseList = new ArrayList<>();

    Terrain currentTerrain = TerrainMapper.parseFromLine(fileContentList.get(0));

    for (int indexTondeuse = 1, indexPosition = 1, indexAction = 2;
        indexAction < fileContentList.size();
        indexPosition += 2, indexAction += 2, indexTondeuse++) {

      var currentPosition = fileContentList.get(indexPosition).toUpperCase(Locale.ROOT);
      var currentActions = fileContentList.get(indexAction).toUpperCase(Locale.ROOT);

      Position position = PositionMapper.parseFromLine(currentPosition);
      List<Action> actionList = ActionMapper.parseFromLine(currentActions);

      Tondeuse currentTondeuse =
          Tondeuse.builder().id(indexTondeuse).position(position).actionList(actionList).build();
      tondeuseList.add(currentTondeuse);
    }

    return Instruction.builder().terrain(currentTerrain).tondeuseList(tondeuseList).build();
  }

  @Override
  public void executeInstructionFile(Instruction instruction) {
    var terrain = instruction.getTerrain();
    instruction.getTondeuseList().forEach(tondeuse -> this.executeTondeuse(tondeuse, terrain));
  }

  @Override
  public void executeTondeuse(Tondeuse tondeuse, Terrain terrain) {
    var position = tondeuse.getPosition();
    tondeuse.getActionList().forEach(action -> this.executeAction(terrain, position, action));
    log.info(tondeuse.getPosition().toString());
  }

  @Override
  public void executeAction(Terrain terrain, Position position, Action action) {
    switch (action) {
      case A:
        position.move(terrain);
        break;
      case G:
        position.turnLeft();
        break;
      case D:
        position.turnRight();
        break;
    }
  }
}
