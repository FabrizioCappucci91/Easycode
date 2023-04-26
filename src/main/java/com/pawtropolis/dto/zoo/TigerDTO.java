package com.pawtropolis.dto.zoo;

import com.pawtropolis.converter.AnimalConverter;
import com.pawtropolis.converter.TigerConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
public class TigerDTO extends AnimalWithTailDTO {

  public TigerDTO(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height, Double tailLength) {
    super(name, favoriteFood, age, entryDate, weight, height,tailLength);
  }
  public AnimalConverter getconverter(){
    return new TigerConverter();
  }

}
