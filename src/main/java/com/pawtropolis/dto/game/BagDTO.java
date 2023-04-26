package com.pawtropolis.dto.game;

import lombok.*;

import java.util.HashMap;
import java.util.Map;
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
public class BagDTO {
  @Getter
  @Setter
  private Long id;

  @Getter
  private final Map<String, ItemDTO> items;
  private static final Integer MAX_SLOTS =10;
  @Getter
  private int availableSlots;

  public Integer getMaxSlots(){
    return MAX_SLOTS;
  }
  public BagDTO(){
    availableSlots=getMaxSlots();
    items=new HashMap<>();
  }
  public BagDTO(Map<String, ItemDTO> items) {
    availableSlots=getMaxSlots();
    this.items = items;
  }

  public boolean checkBagSpace(ItemDTO itemDTO){
    return availableSlots- itemDTO.getRequiredSlots()>=0;
  }
  public ItemDTO addItem(ItemDTO itemDTO){
    if (checkBagSpace(itemDTO)){
      availableSlots-= itemDTO.getRequiredSlots();
      return items.put(itemDTO.getName(), itemDTO);
    }
    return null;
  }
  public ItemDTO removeItem(ItemDTO itemDTO){
    if(items.remove(itemDTO.getName(), itemDTO)){
      availableSlots+= itemDTO.getRequiredSlots();
      return itemDTO;
    }
    return null;
  }
  public ItemDTO removeItem(String name){
    ItemDTO itemDTO =items.get(name);
    return itemDTO !=null?removeItem(itemDTO):null;
  }

  public void removeAllItems(){
    items.clear();
  }
  public boolean isFull() {
    return items.size() == MAX_SLOTS;
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

}
