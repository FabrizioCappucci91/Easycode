package com.animals.model;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public class Tiger extends AnimalWithTail {

  public Tiger(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height,Double tailLength) {
    super(name, favoriteFood, age, entryDate, weight, height,tailLength);
  }
}
