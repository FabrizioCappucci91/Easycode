package com.pawtropolis.dto.zoo;

import com.pawtropolis.converter.AnimalConverter;
import com.pawtropolis.converter.EagleConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
public class EagleDTO extends AnimalWithWingsDTO {


  public EagleDTO(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height, Double wingSpan) {
    super(name, favoriteFood, age, entryDate, weight, height,wingSpan);
  }
  public  AnimalConverter getconverter(){
    return new EagleConverter();
  }

}
