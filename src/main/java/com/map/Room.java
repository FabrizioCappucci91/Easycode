package com.map;


import com.animals.model.Animal;
import com.game.model.Item;
import lombok.Data;

import java.util.*;
@Data
public class Room {
  private String name;
  private List<Animal> animals;
  private Map<String,Item> items;
  private EnumMap<Direction,Room> adjoiningRooms;

  public Room(String name){
    this.name=name;
    this.animals = new ArrayList<>();
    this.items = new HashMap<>();
    this.adjoiningRooms = new EnumMap<>(Direction.class);
  }

  public Animal addAnimal(Animal animal) {
    animals.add(animal);
    return animal;
  }

  public Animal removeAnimal(Animal animal) {
    return animals.remove(animal) ? animal : null;
  }

  public boolean containsAnimal(Animal animal) {
    return animals.contains(animal);
  }

  public void removeAllAnimals() {
    animals.clear();
  }

  public Item addItem(Item item) {
    items.put(item.getName(),item);
    return item;
  }

  public Item removeItem(String itemName) {
    return items.remove(itemName);
  }

  public void removeAllItems() {
    items.clear();
  }
  public boolean containsItem(Item item) {
    return items.containsKey(item.getName());
  }

}