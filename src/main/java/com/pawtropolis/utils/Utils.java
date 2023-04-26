package com.pawtropolis.utils;

import com.pawtropolis.dto.zoo.AnimalDTO;
import com.pawtropolis.dto.zoo.EagleDTO;
import com.pawtropolis.dto.zoo.LionDTO;
import com.pawtropolis.dto.zoo.TigerDTO;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;
@Slf4j
public class Utils {

  private Utils(){}
  public static List<AnimalDTO> loadZoo(){
    TigerDTO animal1=new TigerDTO("Tiger1","pasta",3,LocalDate.now(),120d,96d,35d);
    TigerDTO animal2=new TigerDTO("Tiger2","carne",2,LocalDate.now(),110d,99d,32d);
    TigerDTO animal3=new TigerDTO("Tiger3","verdura",4,LocalDate.now(),125d,102d,28d);
    AnimalDTO animalDTO4 =new LionDTO("Lion1","caramelle",3,LocalDate.now(),129d,88d,42d);
    AnimalDTO animalDTO5 =new LionDTO("Lion2","cioccolata",6,LocalDate.now(),140d,89d,43d);
    AnimalDTO animalDTO6 =new LionDTO("Lion3","banana",5,LocalDate.now(),100d,98d,29d);
    AnimalDTO animalDTO7 =new EagleDTO("Eagle1","lombrico",2,LocalDate.now(),22d,15d,47d);
    AnimalDTO animalDTO8 =new EagleDTO("Eagle2","scarafaggio",3,LocalDate.now(),19d,19d,49d);
    AnimalDTO animalDTO9 =new EagleDTO("Eagle3","gatto",4,LocalDate.now(),25d,17d,41d);
    List<AnimalDTO> animalDTOS =new ArrayList<>();
    animalDTOS.add(animal1);
    animalDTOS.add(animal2);
    animalDTOS.add(animal3);
    animalDTOS.add(animalDTO4);
    animalDTOS.add(animalDTO5);
    animalDTOS.add(animalDTO6);
    animalDTOS.add(animalDTO7);
    animalDTOS.add(animalDTO8);
    animalDTOS.add(animalDTO9);
    return animalDTOS;
  }

  public static void print(String stringa) {
    log.info(stringa);
  }

}

