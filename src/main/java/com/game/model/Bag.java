package com.game.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;
@EqualsAndHashCode
@ToString
public class Bag {
  private Map<String,Item> items;
  private static final Integer MAX_SLOTS =10;
  private int availableSlots;

  public Integer getMaxSlots(){
    return MAX_SLOTS;
  }
  public Bag(){
    availableSlots=getMaxSlots();
    items=new HashMap<>();
  }
  public Bag(Map<String,Item> items) {
    availableSlots=getMaxSlots();
    this.items = items;
  }

  public boolean checkBagSpace(Item item){
    return availableSlots-item.getRequiredSlots()>=0;
  }
  public Item addItem(Item item){
    if (checkBagSpace(item)){
      availableSlots-=item.getRequiredSlots();
      return items.put(item.getName(),item);
    }
    return null;
  }
  public Item removeItem(Item item){
    if(items.remove(item.getName(),item)){
      availableSlots+=item.getRequiredSlots();
      return item;
    }
    return null;
  }
  public Item removeItem(String name){
    Item item=items.get(name);
    return item!=null?removeItem(item):null;
  }

  public void removeAllItems(){
    items.clear();
  }
  public boolean isFull() {
    return items.size() == MAX_SLOTS;
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }
  public Map<String,Item> getItems() {
    return items;
  }

}
