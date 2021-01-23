package com.mowitnow.driver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Position {
  private int x;
  private int y;
  private Orientation orientation;

  public void moveUp(int limitY) {
    if (this.y < limitY) this.y++;
  }

  public void moveRight(int limitX) {
    if (this.x < limitX) this.x++;
  }

  public void moveDown() {
    if (this.y > 0) this.y--;
  }

  public void moveLeft() {
    if (this.x > 0) this.x--;
  }

  public void turnRight() {
    this.orientation = orientation.nextOrientation();
  }

  public void turnLeft() {
    this.orientation = orientation.prevOrientation();
  }

  public void move(Terrain terrain) {
    int limitX = terrain.width;
    int limitY = terrain.length;
    switch (orientation) {
      case N:
        moveUp(limitY);
        break;
      case E:
        moveRight(limitX);
        break;
      case S:
        moveDown();
        break;
      case O:
        moveLeft();
        break;
    }
  }

  @Override
  public String toString() {
    return x + " " + y + " " + orientation;
  }
}
