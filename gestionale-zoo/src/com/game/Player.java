package com.game;

import java.util.Objects;

public class Player {
  private String name;
  private Integer lifePoints;
  private Bag bag=new Bag();

  public Player(){}
  public Player(String name, Integer lifePoints) {
    this.name = name;
    this.lifePoints = lifePoints;
    bag=new Bag();
  }

  public Bag getBag() {
    return bag;
  }

  public void setBag(Bag bag) {
    this.bag = bag;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getLifePoints() {
    return lifePoints;
  }

  public void setLifePoints(Integer lifePoints) {
    this.lifePoints = lifePoints;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return Objects.equals(name, player.name) && Objects.equals(lifePoints, player.lifePoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lifePoints);
  }

  @Override
  public String toString() {
    return "Player{" +
            "name='" + name + '\'' +
            ", lifePoints=" + lifePoints +
            '}';
  }
}
