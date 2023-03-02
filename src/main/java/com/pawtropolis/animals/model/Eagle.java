package com.pawtropolis.animals.model;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public class Eagle extends AnimalWithWings {


  public Eagle(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height,Double wingSpan) {
    super(name, favoriteFood, age, entryDate, weight, height,wingSpan);
  }
}
