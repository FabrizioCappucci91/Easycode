package com.game.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;
@EqualsAndHashCode
@ToString
public class Player {
  private String name;
  private Integer lifePoints;
  private Bag bag;

  public Player(String name){
    this.name=name;
    bag=new Bag();
  }
  public Player(String name, Integer lifePoints) {
    this.name = name;
    this.lifePoints = lifePoints;
    bag=new Bag();
  }

  public Map<String,Item> getItemsInBag(){
    return bag.getItems();
  }
  public Item addItemInBag(Item item){
     return bag.addItem(item);
  }
  public Item removeItemFromBag(String name){
    Item item=bag.getItems().remove(name);
    if (item != null) {
      return item;
    }
    return null;
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

}
