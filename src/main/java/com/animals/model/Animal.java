package com.animals.model;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class Animal {
  private String name;
  private String favoriteFood;
  private Integer age;
  private LocalDate entryDate;
  private Double weight;
  private Double height;

  protected Animal(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height) {
    this.name = name;
    this.favoriteFood = favoriteFood;
    this.age = age;
    this.entryDate = entryDate;
    this.weight = weight;
    this.height = height;
  }
}
