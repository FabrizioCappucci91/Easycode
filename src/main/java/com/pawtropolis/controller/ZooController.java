package com.pawtropolis.controller;

import com.pawtropolis.dto.zoo.AnimalDTO;
import com.pawtropolis.dto.zoo.AnimalWithTailDTO;
import com.pawtropolis.dto.zoo.AnimalWithWingsDTO;

import java.util.*;
public class ZooController {

  private Map<Class<? extends AnimalDTO>,List<AnimalDTO>> animals;

  public ZooController(){
    this.animals=new HashMap<>();
  }

  public <T extends AnimalDTO> List<T> filterAnimals(Class<T> filterByClass){
    return animals.values().stream()
            .filter(filterByClass::isInstance)
            .map(filterByClass::cast)
            .toList();
  }
  private List<AnimalWithTailDTO> getAllAnimalsWithTail() {
    return filterAnimals(AnimalWithTailDTO.class);
  }

  public AnimalWithTailDTO getAnimalWithLongestTail() {
    return getAllAnimalsWithTail().stream()
            .max(Comparator.comparing(AnimalWithTailDTO::getTailLength))
            .orElse(null);
  }

  public List<AnimalWithWingsDTO> getAllAnimalsWithWings() {
    return filterAnimals(AnimalWithWingsDTO.class);
  }

  public AnimalWithWingsDTO getAnimalWithWidestWingspan() {
    return getAllAnimalsWithWings().stream()
            .max(Comparator.comparing(AnimalWithWingsDTO::getWingspan))
            .orElse(null);
  }

  public <T extends AnimalDTO> T getTallestAnimalByClass(Class<T> clazz) {
    return filterAnimals(clazz).stream()
            .max(Comparator.comparing(AnimalDTO::getHeight))
            .orElse(null);
  }

  public <T extends AnimalDTO> T getShortestAnimalByClass(Class<T> clazz) {
    return filterAnimals(clazz).stream()
            .min(Comparator.comparing(AnimalDTO::getHeight))
            .orElse(null);
  }

  public <T extends AnimalDTO> T getHeaviestAnimalByClass(Class<T> clazz) {
    return filterAnimals(clazz).stream()
            .max(Comparator.comparing(AnimalDTO::getWeight))
            .orElse(null);
  }

  public <T extends AnimalDTO> T getLightestAnimalByClass(Class<T> clazz) {
    return filterAnimals(clazz).stream()
            .min(Comparator.comparing(AnimalDTO::getWeight))
            .orElse(null);
  }

  public void addAnimal(AnimalDTO animalDTO){
    animals.computeIfAbsent(animalDTO.getClass(), k -> new ArrayList<>()).add(animalDTO);
  }
}
