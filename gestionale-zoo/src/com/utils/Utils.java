package com.utils;

import com.animals.model.Animal;
import com.animals.model.Eagle;
import com.animals.model.Lion;
import com.animals.model.Tiger;

import java.time.LocalDate;
import java.util.*;

public class Utils {

  public static List<Animal> loadZoo(){
    Animal animal1=new Tiger("Tiger1","pasta",3,LocalDate.now(),120d,96d,35d);
    Animal animal2=new Tiger("Tiger2","carne",2,LocalDate.now(),110d,99d,32d);
    Animal animal3=new Tiger("Tiger3","verdura",4,LocalDate.now(),125d,102d,28d);
    Animal animal4=new Lion("Lion1","caramelle",3,LocalDate.now(),129d,88d,42d);
    Animal animal5=new Lion("Lion2","cioccolata",6,LocalDate.now(),140d,89d,43d);
    Animal animal6=new Lion("Lion3","banana",5,LocalDate.now(),100d,98d,29d);
    Animal animal7=new Eagle("Eagle1","lombrico",2,LocalDate.now(),22d,15d,47d);
    Animal animal8=new Eagle("Eagle2","scarafaggio",3,LocalDate.now(),19d,19d,49d);
    Animal animal9=new Eagle("Eagle3","gatto",4,LocalDate.now(),25d,17d,41d);
    List<Animal> animals=new ArrayList<>();
    animals.add(animal1);
    animals.add(animal2);
    animals.add(animal3);
    animals.add(animal4);
    animals.add(animal5);
    animals.add(animal6);
    animals.add(animal7);
    animals.add(animal8);
    animals.add(animal9);
    return animals;
  }

  public static void print(String stringa) {
    System.out.println(stringa);
  }

}

