package com.pawtropolis.converter;

import com.pawtropolis.dto.game.ItemDTO;
import com.pawtropolis.dto.map.RoomDTO;
import com.pawtropolis.dto.zoo.AnimalDTO;
import com.pawtropolis.enums.Direction;
import com.pawtropolis.persistence.entity.Animal;
import com.pawtropolis.persistence.entity.Item;
import com.pawtropolis.persistence.entity.Room;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
public class RoomConverter {
  @Value("${converter-class-method-name-convert-to-dto}")
  private static String convert2DTOMethodName;
  @Value("${converter-class-method-name-convert-to-entity}")
  private static String convert2EntityMethodName;

  @Value("${converter-class-method-name-convert-to-dto}")
  public static RoomDTO convert2DTO(Room obj) throws InvocationTargetException, IllegalAccessException {
    if (obj==null) return null;


    EnumMap<Direction,RoomDTO> roomEnumMap=new EnumMap<>(Direction.class);
    for (Map.Entry<Direction, Room> entry:obj.getAdjoiningRooms().entrySet()){
      roomEnumMap.put(entry.getKey(), RoomConverter.convert2DTO(entry.getValue()));
    }

    Map<String, ItemDTO> itemMap=new HashMap<>();
    for (Map.Entry<String, Item> entry:obj.getItems().entrySet()){
      itemMap.put(entry.getKey(), ItemConverter.convert2DTO(entry.getValue()));
    }

    List<AnimalDTO> animals=new ArrayList<>();
    for (Animal animal:obj.getAnimals()){
      animals.add((AnimalDTO) Arrays.stream(animal.getconverter().getClass().getDeclaredMethods()).filter(method ->
              method.getName().equalsIgnoreCase(convert2DTOMethodName)).findFirst().get().invoke(animal));
    }

    return RoomDTO.builder()
            .id(obj.getId())
            .name(obj.getName())
            .items(itemMap)
            .animals(animals)
            .adjoiningRooms(roomEnumMap)
            .build();
  }
  @Value("${converter-class-method-name-convert-to-entity}")
  public static Room convert2Entity(RoomDTO obj) throws InvocationTargetException, IllegalAccessException {
    if (obj==null) return null;

    Map<String, Item> itemMap=new HashMap<>();
    for (Map.Entry<String, ItemDTO> entry:obj.getItems().entrySet()){
      itemMap.put(entry.getKey(), ItemConverter.convert2Entity(entry.getValue()));
    }

    EnumMap<Direction,Room> roomEnumMap=new EnumMap<>(Direction.class);
    for (Map.Entry<Direction, RoomDTO> entry:obj.getAdjoiningRooms().entrySet()){
      roomEnumMap.put(entry.getKey(), RoomConverter.convert2Entity(entry.getValue()));
    }
    List<Animal> animals=new ArrayList<>();
    for (AnimalDTO animalDTO:obj.getAnimals()){

      animals.add((Animal) Arrays.stream(animalDTO.getconverter().getClass().getDeclaredMethods()).filter(method ->
              method.getName().equalsIgnoreCase(convert2EntityMethodName)).findFirst().get().invoke(animalDTO));
    }

    return Room.builder()
            .id(obj.getId())
            .name(obj.getName())
            .items(itemMap)
            .animals(animals)
            .adjoiningRooms(roomEnumMap)
            .build();
  }

}
