package com.pawtropolis.dto.map;


import com.pawtropolis.dto.game.ItemDTO;
import com.pawtropolis.dto.zoo.AnimalDTO;
import com.pawtropolis.enums.Direction;
import lombok.*;

import java.util.*;
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@Data
public class RoomDTO {

  private String name;
  private List<AnimalDTO> animals;
  private Map<String, ItemDTO> items;
  private EnumMap<Direction,RoomDTO> adjoiningRooms;
  private Long id;

  public RoomDTO(String name){
    this.name=name;
    this.animals = new ArrayList<>();
    this.items = new HashMap<>();
    this.adjoiningRooms = new EnumMap<>(Direction.class);
  }

  public RoomDTO goAdjoiningRoom(Direction direction){
    return this.adjoiningRooms.get(direction);
  }
  public AnimalDTO addAnimal(AnimalDTO animalDTO) {
    animals.add(animalDTO);
    return animalDTO;
  }

  public AnimalDTO removeAnimal(AnimalDTO animalDTO) {
    return animals.remove(animalDTO) ? animalDTO : null;
  }

  public boolean containsAnimal(AnimalDTO animalDTO) {
    return animals.contains(animalDTO);
  }

  public void removeAllAnimals() {
    animals.clear();
  }

  public ItemDTO addItem(ItemDTO itemDTO) {
    items.put(itemDTO.getName(), itemDTO);
    return itemDTO;
  }

  public ItemDTO removeItem(String itemName) {
    return items.remove(itemName);
  }

  public void removeAllItems() {
    items.clear();
  }
  public boolean containsItem(String itemName) {
    return items.containsKey(itemName);
  }
  public String showAnimals(){
    List<String> info= animals.stream().map(AnimalDTO::getName).toList();
    return info.toString();
  }
  public String showItems(){
    List<String> info=new ArrayList<>();
    for (ItemDTO i:items.values()){
      info.add("Name: "+i.getName()+" Description: "+i.getDescription()+" Required slots: "+i.getRequiredSlots());
    }
    return info.toString();
  }

}