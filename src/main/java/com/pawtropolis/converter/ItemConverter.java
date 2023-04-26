package com.pawtropolis.converter;

import com.pawtropolis.dto.game.ItemDTO;
import com.pawtropolis.persistence.entity.Bag;
import com.pawtropolis.persistence.entity.Item;
import com.pawtropolis.persistence.entity.Room;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Value;

public class ItemConverter {
  private static EntityManager entityManager;

  @Value("${converter-class-method-name-convert-to-dto}")
  public static ItemDTO convert2DTO(Item obj) {
    if (obj==null) return null;

    return ItemDTO.builder()
            .id(obj.getId())
            .description(obj.getDescription())
            .name(obj.getName())
            .requiredSlots(obj.getRequiredSlots())
            .roomId(obj.getRoom().getId())
            .bagId(obj.getBag().getId())
            .build();
  }
  @Value("${converter-class-method-name-convert-to-entity}")
  public static Item convert2Entity(ItemDTO obj) {
    if (obj==null) return null;
    return Item.builder()
            .id(obj.getId())
            .requiredSlots(obj.getRequiredSlots())
            .name(obj.getName())
            .description(obj.getDescription())
            .bag(entityManager.getReference(Bag.class,obj.getBagId()))
            .room(entityManager.getReference(Room.class,obj.getRoomId()))
            .build();
  }

}
