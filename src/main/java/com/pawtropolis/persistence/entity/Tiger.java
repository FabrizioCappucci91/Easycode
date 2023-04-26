package com.pawtropolis.persistence.entity;

import com.pawtropolis.converter.AnimalConverter;
import com.pawtropolis.converter.TigerConverter;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue(value = "tiger")
@SuperBuilder
@AllArgsConstructor
public class Tiger extends AnimalWithTail{

  @Override
  public AnimalConverter getconverter() {
    return new TigerConverter();
  }
}
