package com.game;

import java.util.Objects;

public class Item {
  private String name;
  private String description;
  private Integer requiredSlots;

  public Item(){}

  public Item(String name, String description, Integer requiredSlots) {
    this.name = name;
    this.description = description;
    this.requiredSlots = requiredSlots;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setRequiredSlots(Integer requiredSlots) {
    this.requiredSlots = requiredSlots;
  }

  public Integer getRequiredSlots() {
    return requiredSlots;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(requiredSlots, item.requiredSlots);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, requiredSlots);
  }

  @Override
  public String toString() {
    return "Item{" +
            "name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", requiredSlots=" + requiredSlots +
            '}';
  }
}
