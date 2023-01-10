package com.utils;

import com.animals.Animal;
import com.animals.SpecieAnimale;

import java.time.LocalDate;
import java.util.*;

public class UtilsZoo {

  public static List<Animal> uploadZoo(){
    Animal animal1=new Animal("Tiger1","pasta",3,LocalDate.now(),120d,96d,35d,SpecieAnimale.TIGRE);
    Animal animal2=new Animal("Tiger2","carne",2,LocalDate.now(),110d,99d,32d,SpecieAnimale.TIGRE);
    Animal animal3=new Animal("Tiger3","verdura",4,LocalDate.now(),125d,102d,28d,SpecieAnimale.TIGRE);
    Animal animal4=new Animal("Lion1","caramelle",3,LocalDate.now(),129d,88d,42d,SpecieAnimale.LEONE);
    Animal animal5=new Animal("Lion2","cioccolata",6,LocalDate.now(),140d,89d,43d,SpecieAnimale.LEONE);
    Animal animal6=new Animal("Lion3","banana",5,LocalDate.now(),100d,98d,29d,SpecieAnimale.LEONE);
    Animal animal7=new Animal("Eagle1","lombrico",2,LocalDate.now(),22d,15d,47d,SpecieAnimale.AQUILA);
    Animal animal8=new Animal("Eagle2","scarafaggio",3,LocalDate.now(),19d,19d,49d,SpecieAnimale.AQUILA);
    Animal animal9=new Animal("Eagle3","gatto",4,LocalDate.now(),25d,17d,41d,SpecieAnimale.AQUILA);
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

  public static SpecieAnimale askSpecies(Scanner scanner) {
    print("Which animal species do you wanna choose?");
    print("1. Tigers");
    print("2. Lions");
    print("3. Eagles");
    Integer var = null;
    do {
      try {
        print("Insert number between 1 e 3");
        var = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException numberFormatException) {
        print("Wrong format");
      }
    } while (null == var || var < 1 || var > 3);
    SpecieAnimale specieAnimale = null;
    switch (var) {
      case 1:
        specieAnimale = SpecieAnimale.TIGRE;
        break;
      case 2:
        specieAnimale = SpecieAnimale.LEONE;
        break;
      case 3:
        specieAnimale = SpecieAnimale.AQUILA;
        break;
    }
    return specieAnimale;
  }

  public static void print(String stringa) {
    System.out.println(stringa);
  }

  public static Integer insertIntegerNumber(Scanner scanner) {
    Integer var = null;
    do {
      try {
        print("Insert number value");
        var = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException numberFormatException) {
        print("Wrong format");
      }
    } while (var == null);
    return var;
  }
  public static Double insertDoubleNumber(Scanner scanner) {
    Double var = null;
    do {
      try {
        print("Insert number");
        var = Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException numberFormatException) {
        print("Wrong format");
      }
    } while (var == null);
    return var;
  }

  public static Animal anagraficaAnimale(Scanner scanner, SpecieAnimale specieAnimale) {
    print("Insert name");
    String name = scanner.nextLine();
    print("Insert favorite food");
    String favoriteFood = scanner.nextLine();
    print("Insert age");
    Integer age = insertIntegerNumber(scanner);
    print("Insert weight");
    Double weight = insertDoubleNumber(scanner);
    print("Insert height");
    Double height = insertDoubleNumber(scanner);
    Double length;
    if (!specieAnimale.equals(SpecieAnimale.AQUILA)) {
      print("Insert tail length");
      length = insertDoubleNumber(scanner);
    } else {
      print("Insert wingspan");
      length = insertDoubleNumber(scanner);
    }
    Animal animal = new Animal(name, favoriteFood, age, LocalDate.now(), weight, height, length, specieAnimale);
    return animal;
  }

  public static Boolean checkZoo(List<Animal> esemplari) {
    if (esemplari.isEmpty()) {
      print("No animals present");
      return false;
    }
    return true;
  }

  public static List<Animal> filterAnimals(SpecieAnimale specieAnimale, List<Animal> esemplari) {
    List<Animal> animali = new ArrayList<>();
    switch (specieAnimale) {
      case TIGRE ->
              animali = esemplari.stream().filter(animale -> animale.getSpecie().equals(SpecieAnimale.TIGRE)).toList();
      case LEONE ->
              animali = esemplari.stream().filter(animale -> animale.getSpecie().equals(SpecieAnimale.LEONE)).toList();
      case AQUILA ->
              animali = esemplari.stream().filter(animale -> animale.getSpecie().equals(SpecieAnimale.AQUILA)).toList();
    }
    return animali;
  }

  public static List<Animal> mostLess(List<Animal> animali, String comparatore) {
    ArrayList<Animal> animales = new ArrayList<>(animali);
    if (animali.size() > 1) {
      switch (comparatore) {
        case "height" -> Collections.sort(animales, Comparator.comparing(Animal::getHeight).reversed());
        case "weight" -> Collections.sort(animales, Comparator.comparing(Animal::getWeight).reversed());
        case "length" -> Collections.sort(animales, Comparator.comparing(Animal::getLenght).reversed());
      }
      return animales;
      }
    animales.add(0, animali.get(0));
    animales.add(1, animali.get(0));
    return animales;
  }
}

