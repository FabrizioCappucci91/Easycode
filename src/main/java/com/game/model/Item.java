package com.game.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Item {
  private String name;
  private String description;
  private Integer requiredSlots;

}
