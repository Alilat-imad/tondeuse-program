package com.mowitnow.driver.model;

import com.mowitnow.driver.factoryBuilder.TerrainFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

  Position position;
  Terrain terrain;

  @BeforeEach
  void setUp() {
    position = Position.builder().x(3).y(4).orientation(Orientation.N).build();
    terrain = TerrainFactory.terrain_5x5().build();
  }

  @Test
  void moveUp_WhenLimitIsNotReached() {
    int limitY = 5;
    // when
    position.moveUp(limitY);
    // then
    assertThat(position.getY()).isEqualTo(5);
  }

  @Test
  void moveUp_WhenLimitIsReached() {
    int limitY = 4;
    // when
    position.moveUp(limitY);
    // then
    assertThat(position.getY()).isEqualTo(4);
  }

  @Test
  void moveRight_WhenLimitIsNotReached() {
    int limitX = 5;
    // when
    position.moveRight(limitX);
    // then
    assertThat(position.getX()).isEqualTo(4);
  }

  @Test
  void moveRight_WhenLimitIsReached() {
    int limitX = 3;
    // when
    position.moveRight(limitX);
    // then
    assertThat(position.getX()).isEqualTo(3);
  }

  @Test
  void moveDown_WhenLimitIsNotReached() {
    // when
    position.moveDown();
    // then
    assertThat(position.getY()).isEqualTo(3);
  }

  @Test
  void moveDown_WhenLimitIsReached() {
    // given
    position.setY(0);
    // when
    position.moveDown();
    // then
    assertThat(position.getY()).isZero();
  }

  @Test
  void moveLeft_WhenLimitIsNotReached() {
    // when
    position.moveLeft();
    // then
    assertThat(position.getX()).isEqualTo(2);
  }

  @Test
  void moveLeft_WhenLimitIsReached() {
    // given
    position.setX(0);
    // when
    position.moveLeft();
    // then
    assertThat(position.getX()).isZero();
  }

  // TODO
  @Test
  void move() {}
}
