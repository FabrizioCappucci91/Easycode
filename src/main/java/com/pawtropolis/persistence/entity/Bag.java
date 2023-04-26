package com.pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Builder
@AllArgsConstructor
@Entity
@Table(name = "bag")
@Data
public class Bag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Transient
  private final Map<String, Item> items;
  @Column(name ="max_slots")
  private static final Integer MAX_SLOTS =10;
  @Column(name = "available_slots")
  private int availableSlots;

  public Integer getMaxSlots(){
    return MAX_SLOTS;
  }

  public Bag(){
    availableSlots=getMaxSlots();
    items=new HashMap<>();
  }
  public Bag(Map<String, Item> items) {
    availableSlots=getMaxSlots();
    this.items = items;
  }

}
