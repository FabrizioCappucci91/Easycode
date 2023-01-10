package com.game;

import java.util.*;

public class Bag {
  private Map<String,Item> items=new HashMap<>();
  private static final Integer AVAILABLE_SLOTS=10;

  public Integer getAvailableSlots(){
    return AVAILABLE_SLOTS;
  }
  public Bag(){}
  public Bag(Map<String,Item> items) {
    this.items = items;
  }

  public Map<String,Item> getItems() {
    return items;
  }

  public void setItems(Map<String,Item> items) {
    this.items = items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bag bag = (Bag) o;
    return Objects.equals(items, bag.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    return items.toString();
  }
}
