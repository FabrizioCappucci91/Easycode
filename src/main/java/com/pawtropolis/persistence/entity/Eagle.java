package com.pawtropolis.persistence.entity;

import com.pawtropolis.converter.AnimalConverter;
import com.pawtropolis.converter.EagleConverter;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@DiscriminatorValue(value = "eagle")
public class Eagle extends AnimalWithWings{

  @Override
  public AnimalConverter getconverter() {
    return new EagleConverter();
  }
}
