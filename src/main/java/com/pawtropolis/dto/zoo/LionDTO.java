package com.pawtropolis.dto.zoo;

import com.pawtropolis.converter.AnimalConverter;
import com.pawtropolis.converter.LionConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
public class LionDTO extends AnimalWithTailDTO {


  public LionDTO(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height, Double tailLength) {
    super(name, favoriteFood, age, entryDate, weight, height,tailLength);
  }
  public AnimalConverter getconverter(){
    return new LionConverter();
  }

}
