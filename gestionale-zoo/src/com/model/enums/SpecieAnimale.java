package com.model.enums;

public enum SpecieAnimale {
  TIGRE("Tigre"),
  LEONE("Leone"),
  AQUILA("Aquila");

  public final String tipo;

  SpecieAnimale(String specie) {
    this.tipo=specie;
  }
  private String getTipo(){
    return tipo;
  }
}
