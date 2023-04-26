package com.pawtropolis.converter;

import com.pawtropolis.dto.zoo.TigerDTO;
import com.pawtropolis.persistence.entity.Room;
import com.pawtropolis.persistence.entity.Tiger;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Value;

public class TigerConverter implements AnimalConverter{
  private static EntityManager entityManager;

  @Value("${converter-class-method-name-convert-to-dto}")
  public static TigerDTO convert2DTO(Tiger obj){
    return TigerDTO.builder()
            .id(obj.getId())
            .age(obj.getAge())
            .height(obj.getHeight())
            .weight(obj.getWeight())
            .entryDate(obj.getEntryDate())
            .favoriteFood(obj.getFavoriteFood())
            .name(obj.getName())
            .tailLength(obj.getTailLength())
            .roomId(obj.getRoom().getId())
            .build();
  }

  @Value("${converter-class-method-name-convert-to-entity}")
  public static Tiger convert2Entity(TigerDTO obj){
    return Tiger.builder()
            .id(obj.getId())
            .age(obj.getAge())
            .height(obj.getHeight())
            .weight(obj.getWeight())
            .entryDate(obj.getEntryDate())
            .favoriteFood(obj.getFavoriteFood())
            .name(obj.getName())
            .tailLength(obj.getTailLength())
            .room(entityManager.getReference(Room.class,obj.getRoomId()))
            .build();
  }
}
