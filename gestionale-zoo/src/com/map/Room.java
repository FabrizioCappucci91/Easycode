package com.map;


import com.animals.model.Animal;
import com.game.model.Item;

import java.util.*;

public class Room {
  private String name;
  private List<Animal> animals;
  private Map<String,Item> items;
  private EnumMap<Direction,Room> adjoiningRooms;

  public Room(String name){
    this.name=name;
    this.animals = new ArrayList<>();
    this.items = new HashMap<>();
    this.adjoiningRooms = new EnumMap(Direction.class);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Animal> getAnimals() {
    return animals;
  }

  public void setAnimals(List<Animal> animals) {
    this.animals = animals;
  }

  public Map<String,Item> getItems() {
    return items;
  }

  public void setItems(Map<String,Item> items) {
    this.items = items;
  }

  public EnumMap<Direction, Room> getAdjoiningRooms() {
    return adjoiningRooms;
  }

  public void setAdjoiningRooms(EnumMap<Direction, Room> adjoiningRooms) {
    this.adjoiningRooms = adjoiningRooms;
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


  @Override
  public boolean equals(Object o) {

    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Room room = (Room) o;
    return Objects.equals(name, room.name) && Objects.equals(animals, room.animals) && Objects.equals(items, room.items) && Objects.equals(adjoiningRooms, room.adjoiningRooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, animals, items, adjoiningRooms);
  }

  @Override
  public String toString() {
    return "Room{" +
            "name='" + name + '\'' +
            ", animals=" + animals +
            ", items=" + items +
            ", adjoiningRooms=" + adjoiningRooms +
            '}';
  }
}