package com.utils;

import com.game.Item;
import com.game.Player;
import com.map.Room;

import java.util.HashMap;
import java.util.Map;

public class UtilsGame {
  public static void fillGame(Room room , Player player){
    room.setName("Main room");
    room.setAnimals(UtilsZoo.uploadZoo());
    Item item1=new Item("item1","itemDiValore",2);
    Item item2=new Item("item2","itemDiValore2",3);
    Map<String,Item> items=new HashMap<>();
    items.put(item1.getName(),item1);
    items.put(item2.getName(),item2);
    room.setItems(items);
    player.setName("Player1");
    player.setLifePoints(50);
  }
}
