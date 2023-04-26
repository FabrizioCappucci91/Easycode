package com.pawtropolis.persistence.entity;

import com.pawtropolis.converter.AnimalConverter;
import com.pawtropolis.converter.LionConverter;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue(value = "lion")
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Lion extends AnimalWithTail{

  @Override
  public AnimalConverter getconverter() {
    return new LionConverter();
  }
}
