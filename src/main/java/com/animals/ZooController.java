package com.animals;

import com.animals.model.Animal;
import com.animals.model.AnimalWithTail;
import com.animals.model.AnimalWithWings;

import java.util.*;
public class ZooController {

  private Map<Class<? extends Animal>,List<Animal>> animals;

  public ZooController(){
    this.animals=new HashMap<>();
  }

  public <T extends Animal> List<T> filterAnimals(Class<T> filterByClass){
    return animals.values().stream()
            .filter(filterByClass::isInstance)
            .map(filterByClass::cast)
            .toList();
  }
  private List<AnimalWithTail> getAllAnimalsWithTail() {
    return filterAnimals(AnimalWithTail.class);
  }

  public AnimalWithTail getAnimalWithLongestTail() {
    return getAllAnimalsWithTail().stream()
            .max(Comparator.comparing(AnimalWithTail::getTailLength))
            .orElse(null);
  }

  public List<AnimalWithWings> getAllAnimalsWithWings() {
    return filterAnimals(AnimalWithWings.class);
  }

  public AnimalWithWings getAnimalWithWidestWingspan() {
    return getAllAnimalsWithWings().stream()
            .max(Comparator.comparing(AnimalWithWings::getWingspan))
            .orElse(null);
  }

  public <T extends Animal> T getTallestAnimalByClass(Class<T> clazz) {
    return filterAnimals(clazz).stream()
            .max(Comparator.comparing(Animal::getHeight))
            .orElse(null);
  }

  public <T extends Animal> T getShortestAnimalByClass(Class<T> clazz) {
    return filterAnimals(clazz).stream()
            .min(Comparator.comparing(Animal::getHeight))
            .orElse(null);
  }

  public <T extends Animal> T getHeaviestAnimalByClass(Class<T> clazz) {
    return filterAnimals(clazz).stream()
            .max(Comparator.comparing(Animal::getWeight))
            .orElse(null);
  }

  public <T extends Animal> T getLightestAnimalByClass(Class<T> clazz) {
    return filterAnimals(clazz).stream()
            .min(Comparator.comparing(Animal::getWeight))
            .orElse(null);
  }

  public void addAnimal(Animal animal){
    animals.computeIfAbsent(animal.getClass(), k -> new ArrayList<>()).add(animal);
  }
}
