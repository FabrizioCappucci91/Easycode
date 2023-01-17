package com.animals.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Animal {
  private String name;
  private String favoriteFood;
  private Integer age;
  private LocalDate entryDate;
  private Double weight;
  private Double height;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Animal animal = (Animal) o;
    return Objects.equals(name, animal.name) && Objects.equals(favoriteFood, animal.favoriteFood) && Objects.equals(age, animal.age) && Objects.equals(entryDate, animal.entryDate) && Objects.equals(weight, animal.weight) && Objects.equals(height, animal.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, favoriteFood, age, entryDate, weight, height);
  }

  public Animal(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height){
    this.name =name;
    this.favoriteFood=favoriteFood;
    this.age=age;
    this.entryDate=entryDate;
    this.weight=weight;
    this.height =height;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFavoriteFood() {
    return favoriteFood;
  }

  public void setFavoriteFood(String favoriteFood) {
    this.favoriteFood = favoriteFood;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDate getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(LocalDate entryDate) {
    this.entryDate = entryDate;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }
}
