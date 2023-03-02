package com.pawtropolis.map;

import java.util.Arrays;

public enum Direction {
  NORTH("north"),
  SOUTH("south"),
  EAST("east"),
  WEST("west"),
  INVALID(null);

  private String direction;
  Direction(String direction){
    this.direction=direction;
  }

  private String getDirection(){
    return direction;
  }
  public static Direction of(String s) {
    return Arrays.stream(values())
            .filter(d -> s.equalsIgnoreCase(d.getDirection()))
            .findAny()
            .orElse(INVALID);
  }
}
