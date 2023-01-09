package com.utils;

import com.model.Animale;
import com.model.enums.SpecieAnimale;

import java.util.*;

public class Utils {

  public static SpecieAnimale chiediSpecie(Scanner scanner) {
    System.out.println("Che tipo di specie di animale desidera trattare?");
    System.out.println("1. Tigri");
    System.out.println("2. Leoni");
    System.out.println("3. Aquile");
    Integer var = null;
    do {
      try {
        System.out.println("Inserire un numero compreso tra 1 e 3");
        var = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException numberFormatException) {
        System.out.println("Formato errato");
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

  public static void stampa(String stringa) {
    System.out.println(stringa);
  }

  public static Integer inserisciNumero(Scanner scanner) {
    Integer var = null;
    do {
      try {
        System.out.println("Inserire un valore numerico");
        var = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException numberFormatException) {
        System.out.println("Formato errato");
      }
    } while (var == null);
    return var;
  }

  public static Animale anagraficaAnimale(Scanner scanner, SpecieAnimale specieAnimale) {
    System.out.println("Inserisci nome animale");
    String nome = scanner.nextLine();
    System.out.println("Inserisci cibo preferito");
    String cibo = scanner.nextLine();
    System.out.println("Inserisci età");
    Integer eta = inserisciNumero(scanner);
    System.out.println("Inserisci data ingresso allo zoo");
    String dataIngresso = scanner.nextLine();
    System.out.println("Inserisci peso");
    Integer peso = inserisciNumero(scanner);
    System.out.println("Inserisci altezza");
    Integer altezza = inserisciNumero(scanner);
    Integer lunghezza;
    if (!specieAnimale.equals(SpecieAnimale.AQUILA)) {
      System.out.println("Inserisci lunghezza coda");
      lunghezza = inserisciNumero(scanner);
    } else {
      System.out.println("Inserisci apertura alare");
      lunghezza = inserisciNumero(scanner);
    }
    Animale animale = new Animale(nome, cibo, eta, dataIngresso, peso, altezza, lunghezza, specieAnimale);
    return animale;
  }

  public static Boolean checkZoo(List<Animale> esemplari) {
    if (esemplari.isEmpty()) {
      System.out.println("Non ci sono animali nello zoo");
      return false;
    }
    return true;
  }

  public static List<Animale> filterAnimals(SpecieAnimale specieAnimale, List<Animale> esemplari) {
    List<Animale> animali = new ArrayList<>();
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

  public static List<Animale> mostLess(List<Animale> animali, String comparatore) {
    ArrayList<Animale> animales=new ArrayList<>();
    animali.forEach(a->animales.add(a));
    if (animali.size() > 1) {
      switch (comparatore) {
        case "altezza" -> {
          Collections.sort(animales, Comparator.comparing(Animale::getHeight).reversed());
        }
        case "peso" -> {
          Collections.sort(animales, Comparator.comparing(Animale::getWeight).reversed());
        }
        case "lunghezza" -> {
          Collections.sort(animales, Comparator.comparing(Animale::getLenght).reversed());
        }
      }
      return animales;
      }
    animales.add(0, animali.get(0));
    animales.add(1, animali.get(0));
    return animales;
  }
}

