package com.test;

import com.model.Animale;
import com.model.enums.SpecieAnimale;
import com.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static final String ALTEZZA="altezza";
  private static final String PESO="peso";
  private static final String LUNGHEZZA="lunghezza";
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Utils.stampa("Benvenuti nello zoo di Alten. Cosa desidera fare?");
    boolean exit=false;
    List<Animale> esemplari=new ArrayList<>();
    do {
      Utils.stampa("_____________________");
      Utils.stampa("1. Inserisci animale");
      Utils.stampa("2. Ricerca esemplare piu alto ed esemplare piu basso");
      Utils.stampa("3. Ricerca esemplare piu leggero ed esemplare piu pesante");
      Utils.stampa("4. Ricerca esemplare con la coda piu lunga");
      Utils.stampa("5. Ricerca esemplare con la maggiore apertura alare");
      Utils.stampa("6. Esci");
      Integer var;
      do {
        var=Utils.inserisciNumero(sc);
        if(var<1|| var>6) Utils.stampa("Inserisci un valore compreso tra quelli presenti");
      }while (var < 1 || var >6 );
      switch (var){
        case 1:
          esemplari.add(Utils.anagraficaAnimale(sc,Utils.chiediSpecie(sc)));
          Utils.stampa("com.alten.model.Animale inserito correttamente");
          break;
        case 2:
          if (!Utils.checkZoo(esemplari)) break;
          SpecieAnimale specie=Utils.chiediSpecie(sc);
          List<Animale> animaliFiltered=Utils.filterAnimals(specie,esemplari);
          List<Animale> animali=Utils.mostLess(animaliFiltered,ALTEZZA);
          Utils.stampa("L'esemplare di "+specie.tipo+" piu alto e' "+animali.get(0));
          Utils.stampa("L'esemplare di "+specie.tipo+" piu basso e' "+animali.get(animali.size()-1));
          break;
        case 3:
          if (!Utils.checkZoo(esemplari)) break;
          SpecieAnimale specie2=Utils.chiediSpecie(sc);
          List<Animale> animaliFiltered2=Utils.filterAnimals(specie2,esemplari);
          List<Animale> animali2=Utils.mostLess(animaliFiltered2,PESO);
          Utils.stampa("L'esemplare di "+specie2.tipo+" piu pesante e' "+animali2.get(0));
          Utils.stampa("L'esemplare di "+specie2.tipo+" piu leggero e' "+animali2.get(animali2.size()-1));
          break;
        case 4:
          if (!Utils.checkZoo(esemplari)) break;
          List<Animale> animaliFiltered3=esemplari.stream().filter(animale -> !animale.getSpecie().equals(SpecieAnimale.AQUILA)).toList();
          List<Animale> animali3=Utils.mostLess(animaliFiltered3,LUNGHEZZA);
          Utils.stampa("L'esemplare con la coda piu lunga e' "+animali3.get(0));
          break;
        case 5:
          if (!Utils.checkZoo(esemplari)) break;
          List<Animale> animaliFiltered4=Utils.filterAnimals(SpecieAnimale.AQUILA,esemplari);
          List<Animale> animali4=Utils.mostLess(animaliFiltered4,LUNGHEZZA);
          Utils.stampa("L'esemplare di "+SpecieAnimale.AQUILA+" con l'apertura alare piu grande e' "+animali4.get(0));
          break;
        case 6:
          exit=true;
          break;
      }
    }while(!exit);
    sc.close();
    Utils.stampa("Arrivederci e grazie");
  }
}