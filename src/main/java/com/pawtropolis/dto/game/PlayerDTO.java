package com.pawtropolis.dto.game;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@Data
@Component
public class PlayerDTO {

  private Long id;
  private String name;
  private Integer lifePoints;
  private final BagDTO bagDTO;
  @Autowired
  protected PlayerDTO() {
    this.name = "Player";
    bagDTO = new BagDTO();
  }

  public Map<String, ItemDTO> getItemsInBag(){
    return bagDTO.getItems();
  }
  public ItemDTO addItemInBag(ItemDTO itemDTO){
     return bagDTO.addItem(itemDTO);
  }
  public ItemDTO removeItemFromBag(String name){
    ItemDTO itemDTO = bagDTO.getItems().remove(name);
    if (itemDTO != null) {
      return itemDTO;
    }
    return null;
  }
}
