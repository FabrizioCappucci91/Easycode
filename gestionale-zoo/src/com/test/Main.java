package com.test;

import com.animals.Animal;
import com.animals.SpecieAnimale;
import com.game.GameController;
import com.game.Player;
import com.map.Room;
import com.utils.UtilsZoo;

import java.util.List;
import java.util.Scanner;

public class Main {
  private static final String HEIGHT ="height";
  private static final String WEIGHT ="weight";
  private static final String LENGTH ="length";
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    UtilsZoo.print("Welcome to Pawtropolis. What do you wanna do?");
    boolean exit=false;
    List<Animal> esemplari= UtilsZoo.uploadZoo();
    GameController gameController= new GameController();
    gameController.runGame();
    /*do {
      UtilsZoo.print("_____________________");
      UtilsZoo.print("1. Insert animal");
      UtilsZoo.print("2. Search for taller and lower exemplary");
      UtilsZoo.print("3. Search for heavier and lighter exemplary");
      UtilsZoo.print("4. Search for longest tail exemplary");
      UtilsZoo.print("5. Search for greater wingspan exemplary");
      UtilsZoo.print("6. Exit");
      Integer var;
      do {
        var= UtilsZoo.insertIntegerNumber(sc);
        if(var<1|| var>6) UtilsZoo.print("Enter a value between those present");
      }while (var < 1 || var >6 );
      switch (var){
        case 1:
          esemplari.add(UtilsZoo.anagraficaAnimale(sc, UtilsZoo.askSpecies(sc)));
          UtilsZoo.print("Animal inserted successfully");
          break;
        case 2:
          if (!UtilsZoo.checkZoo(esemplari)) break;
          SpecieAnimale specie= UtilsZoo.askSpecies(sc);
          List<Animal> animaliFiltered= UtilsZoo.filterAnimals(specie,esemplari);
          List<Animal> animali= UtilsZoo.mostLess(animaliFiltered, HEIGHT);
          UtilsZoo.print("Taller exemplary of "+specie.type +" is "+animali.get(0));
          UtilsZoo.print("Lower exemplary of "+specie.type +" is "+animali.get(animali.size()-1));
          break;
        case 3:
          if (!UtilsZoo.checkZoo(esemplari)) break;
          SpecieAnimale specie2= UtilsZoo.askSpecies(sc);
          List<Animal> animaliFiltered2= UtilsZoo.filterAnimals(specie2,esemplari);
          List<Animal> animali2= UtilsZoo.mostLess(animaliFiltered2, WEIGHT);
          UtilsZoo.print("Heavier exemplary of "+specie2.type +" is "+animali2.get(0));
          UtilsZoo.print("Lighter exemplary of "+specie2.type +" is "+animali2.get(animali2.size()-1));
          break;
        case 4:
          if (!UtilsZoo.checkZoo(esemplari)) break;
          List<Animal> animaliFiltered3=esemplari.stream().filter(animale -> !animale.getSpecie().equals(SpecieAnimale.AQUILA)).toList();
          List<Animal> animali3= UtilsZoo.mostLess(animaliFiltered3, LENGTH);
          UtilsZoo.print("Exemplary with longest tail is "+animali3.get(0));
          break;
        case 5:
          if (!UtilsZoo.checkZoo(esemplari)) break;
          List<Animal> animaliFiltered4= UtilsZoo.filterAnimals(SpecieAnimale.AQUILA,esemplari);
          List<Animal> animali4= UtilsZoo.mostLess(animaliFiltered4, LENGTH);
          UtilsZoo.print("Exemplary of "+SpecieAnimale.AQUILA+" with greater wingspan is "+animali4.get(0));
          break;
        case 6:
          exit=true;
          break;
      }
    }while(!exit);*/
    sc.close();
    UtilsZoo.print("Bye bye");
  }
}