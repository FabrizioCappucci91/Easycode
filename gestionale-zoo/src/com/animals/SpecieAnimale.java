package com.animals;

public enum SpecieAnimale {
  TIGRE("Tiger"),
  LEONE("Lion"),
  AQUILA("Eagle");

  public final String type;

  SpecieAnimale(String specie) {
    this.type =specie;
  }
  private String getType(){
    return type;
  }
}
