package com.pawtropolis.map;


import com.pawtropolis.animals.model.Animal;
import com.pawtropolis.game.model.Item;
import lombok.*;

import java.util.*;
@EqualsAndHashCode
@ToString
public class Room {
  @Getter
  @Setter
  @NonNull
  private String name;
  @Setter
  private List<Animal> animals;
  @Setter
  private Map<String,Item> items;
  @Setter
  private EnumMap<Direction,Room> adjoiningRooms;

  public Room(String name){
    this.name=name;
    this.animals = new ArrayList<>();
    this.items = new HashMap<>();
    this.adjoiningRooms = new EnumMap<>(Direction.class);
  }

  public Room goAdjoiningRoom(Direction direction){
    return this.adjoiningRooms.get(direction);
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
  public boolean containsItem(String itemName) {
    return items.containsKey(itemName);
  }
  public String showAnimals(){
    return animals.toString();
  }
  public String showItems(){
    return items.toString();
  }

}