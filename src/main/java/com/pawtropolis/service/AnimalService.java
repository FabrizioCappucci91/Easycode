package com.pawtropolis.service;

import com.pawtropolis.persistence.entity.Animal;
import com.pawtropolis.persistence.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

  private final AnimalRepository animalRepository;

  public void saveAnimal(Animal animal){
    animalRepository.save(animal);
  }

  public List<Animal> getAllAnimals(){
    return animalRepository.findAll();
  }
}
