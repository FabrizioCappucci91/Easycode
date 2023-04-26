package com.pawtropolis.converter;

import com.pawtropolis.dto.game.BagDTO;
import com.pawtropolis.dto.game.ItemDTO;
import com.pawtropolis.persistence.entity.Bag;
import com.pawtropolis.persistence.entity.Item;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

public class BagConverter {

  @Value("${converter-class-method-name-convert-to-dto}")
  public static BagDTO convert2DTO(Bag obj){
    if (obj==null) return null;

    Map<String, ItemDTO> itemDTOMap=new HashMap<>();
    for (Map.Entry<String, Item> entry:obj.getItems().entrySet()){
      itemDTOMap.put(entry.getKey(), ItemConverter.convert2DTO(entry.getValue()));
    }
    return BagDTO.builder()
            .id(obj.getId())
            .availableSlots(obj.getAvailableSlots())
            .items(itemDTOMap)
            .build();
  }
  @Value("${converter-class-method-name-convert-to-entity}")
  public static Bag convert2Entity(BagDTO obj){
    if (obj==null) return null;

    Map<String, Item> itemMap=new HashMap<>();
    for (Map.Entry<String, ItemDTO> entry:obj.getItems().entrySet()){
      itemMap.put(entry.getKey(), ItemConverter.convert2Entity(entry.getValue()));
    }
    return Bag.builder()
            .id(obj.getId())
            .availableSlots(obj.getAvailableSlots())
            .items(itemMap)
            .build();
  }
}
