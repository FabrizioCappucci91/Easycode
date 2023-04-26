package com.pawtropolis.converter;

import com.pawtropolis.dto.zoo.EagleDTO;
import com.pawtropolis.persistence.entity.Eagle;
import com.pawtropolis.persistence.entity.Room;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Value;

public class EagleConverter implements AnimalConverter{
  private static EntityManager entityManager;

  @Value("${converter-class-method-name-convert-to-dto}")
  public static EagleDTO convert2DTO(Eagle obj){
    return EagleDTO.builder()
            .id(obj.getId())
            .age(obj.getAge())
            .height(obj.getHeight())
            .weight(obj.getWeight())
            .entryDate(obj.getEntryDate())
            .favoriteFood(obj.getFavoriteFood())
            .name(obj.getName())
            .roomId(obj.getRoom().getId())
            .wingspan(obj.getWingspan())
            .build();
  }
  @Value("${converter-class-method-name-convert-to-entity}")
  public static Eagle convert2Entity(EagleDTO obj){
    return Eagle.builder()
            .id(obj.getId())
            .age(obj.getAge())
            .height(obj.getHeight())
            .weight(obj.getWeight())
            .entryDate(obj.getEntryDate())
            .favoriteFood(obj.getFavoriteFood())
            .name(obj.getName())
            .room(entityManager.getReference(Room.class,obj.getRoomId()))
            .wingspan(obj.getWingspan())
            .build();
  }
}
