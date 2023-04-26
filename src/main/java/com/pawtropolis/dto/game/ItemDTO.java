package com.pawtropolis.dto.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ItemDTO {

  private Long id;
  private String name;
  private String description;
  private Integer requiredSlots;
  private Long bagId;
  private Long roomId;

  public ItemDTO(String name, String description, int requiredSlots) {
    this.name=name;
    this.description=description;
    this.requiredSlots=requiredSlots;
  }
}
