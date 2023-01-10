package com.map;


import com.animals.Animal;
import com.game.Item;

import java.util.*;

public class Room {
  private String name;
  private List<Animal> animals=new ArrayList<>();
  private Map<String,Item> items=new HashMap<>();
  private Map<String,Room> adjoiningRooms=new HashMap<>(4);

  public Room(){}
  public Room(String name, List<Animal> animals, Map<String,Item> items, Map<String, Room> adjoiningRooms) {
    this.name = name;
    this.animals = animals;
    this.items = items;
    this.adjoiningRooms = adjoiningRooms;
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

  public Map<String, Room> getAdjoiningRooms() {
    return adjoiningRooms;
  }

  public void setAdjoiningRooms(Map<String, Room> adjoiningRooms) {
    this.adjoiningRooms = adjoiningRooms;
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