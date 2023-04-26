package com.pawtropolis.dto.zoo;

import com.pawtropolis.converter.AnimalConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Data
@SuperBuilder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class AnimalDTO {

  private Long id;
  private String name;
  private String favoriteFood;
  private Integer age;
  private LocalDate entryDate;
  private Double weight;
  private Double height;
  private Long roomId;

  protected AnimalDTO(){}

  protected AnimalDTO(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height) {
    this.name = name;
    this.favoriteFood = favoriteFood;
    this.age = age;
    this.entryDate = entryDate;
    this.weight = weight;
    this.height = height;
  }
  public abstract AnimalConverter getconverter();

}
