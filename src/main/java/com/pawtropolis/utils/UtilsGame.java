package com.pawtropolis.utils;

import com.pawtropolis.game.model.Item;
import com.pawtropolis.map.Direction;
import com.pawtropolis.map.Room;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class UtilsGame {
  private UtilsGame(){}
  public static void fillGame(Room room){
    room.setName("Main room");
    room.setAnimals(Utils.loadZoo());
    Item item1=new Item("item1","itemDiValore",2);
    Item item2=new Item("item2","itemDiValore2",3);
    Map<String,Item> items=new HashMap<>();
    items.put(item1.getName(),item1);
    items.put(item2.getName(),item2);
    room.setItems(items);
    Room north= new Room("Room north");
    north.setAnimals(Utils.loadZoo());
    Map<String,Item> itemsNorth=new HashMap<>();
    Item item3=new Item("item3","itemDiValore3",2);
    Item item4=new Item("item4","itemDiValore4",3);
    itemsNorth.put(item3.getName(),item3);
    itemsNorth.put(item4.getName(),item4);
    north.setItems(itemsNorth);
    Room south= new Room("Room south");
    south.setAnimals(Utils.loadZoo());
    Map<String,Item> itemsSouth=new HashMap<>();
    Item item5=new Item("item5","itemDiValore5",2);
    Item item6=new Item("item6","itemDiValore6",3);
    itemsSouth.put(item5.getName(),item5);
    itemsSouth.put(item6.getName(),item6);
    south.setItems(itemsSouth);
    Room east= new Room("Room east");
    east.setAnimals(Utils.loadZoo());
    Map<String,Item> itemsEast=new HashMap<>();
    Item item7=new Item("item7","itemDiValore7",2);
    Item item8=new Item("item8","itemDiValore8",3);
    itemsEast.put(item7.getName(),item7);
    itemsEast.put(item8.getName(),item8);
    east.setItems(itemsEast);
    Room west= new Room("Room west");
    west.setAnimals(Utils.loadZoo());
    Map<String,Item> itemsWest=new HashMap<>();
    Item item9=new Item("item19","itemDiValore9",2);
    Item item10=new Item("item10","itemDiValore10",3);
    itemsWest.put(item9.getName(),item9);
    itemsWest.put(item10.getName(),item10);
    west.setItems(itemsWest);
    EnumMap<Direction,Room> adjRooms=new EnumMap<>(Direction.class);
    adjRooms.put(Direction.NORTH,north);
    adjRooms.put(Direction.SOUTH,south);
    adjRooms.put(Direction.EAST,east);
    adjRooms.put(Direction.WEST,west);
    room.setAdjoiningRooms(adjRooms);
    north.setAdjoiningRooms(adjRooms);
    south.setAdjoiningRooms(adjRooms);
    east.setAdjoiningRooms(adjRooms);
    west.setAdjoiningRooms(adjRooms);
  }
}
