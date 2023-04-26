package com.pawtropolis.converter;

import com.pawtropolis.dto.zoo.LionDTO;
import com.pawtropolis.persistence.entity.Lion;
import com.pawtropolis.persistence.entity.Room;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Value;

public class LionConverter implements AnimalConverter{
  private static EntityManager entityManager;

  @Value("${converter-class-method-name-convert-to-dto}")
  public static LionDTO convert2DTO(Lion obj){
    return LionDTO.builder()
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
  public static Lion convert2Entity(LionDTO obj){
    return Lion.builder()
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
