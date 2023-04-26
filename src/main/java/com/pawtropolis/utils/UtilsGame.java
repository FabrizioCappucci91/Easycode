package com.pawtropolis.utils;

import com.pawtropolis.dto.game.ItemDTO;
import com.pawtropolis.enums.Direction;
import com.pawtropolis.dto.map.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
@Component
public class UtilsGame {

  private UtilsGame(){
  }
  public static void fillGame(RoomDTO roomDTO){
    roomDTO.setAnimals(Utils.loadZoo());
    ItemDTO itemDTO1 =new ItemDTO("item1","itemDiValore",2);
    ItemDTO itemDTO2 =new ItemDTO("item2","itemDiValore2",3);
    Map<String, ItemDTO> items=new HashMap<>();
    items.put(itemDTO1.getName(), itemDTO1);
    items.put(itemDTO2.getName(), itemDTO2);
    roomDTO.setItems(items);
    RoomDTO north= new RoomDTO("Room north");
    north.setAnimals(Utils.loadZoo());
    Map<String, ItemDTO> itemsNorth=new HashMap<>();
    ItemDTO itemDTO3 =new ItemDTO("item3","itemDiValore3",2);
    ItemDTO itemDTO4 =new ItemDTO("item4","itemDiValore4",3);
    itemsNorth.put(itemDTO3.getName(), itemDTO3);
    itemsNorth.put(itemDTO4.getName(), itemDTO4);
    north.setItems(itemsNorth);
    RoomDTO south= new RoomDTO("Room south");
    south.setAnimals(Utils.loadZoo());
    Map<String, ItemDTO> itemsSouth=new HashMap<>();
    ItemDTO itemDTO5 =new ItemDTO("item5","itemDiValore5",2);
    ItemDTO itemDTO6 =new ItemDTO("item6","itemDiValore6",3);
    itemsSouth.put(itemDTO5.getName(), itemDTO5);
    itemsSouth.put(itemDTO6.getName(), itemDTO6);
    south.setItems(itemsSouth);
    RoomDTO east= new RoomDTO("Room east");
    east.setAnimals(Utils.loadZoo());
    Map<String, ItemDTO> itemsEast=new HashMap<>();
    ItemDTO itemDTO7 =new ItemDTO("item7","itemDiValore7",2);
    ItemDTO itemDTO8 =new ItemDTO("item8","itemDiValore8",3);
    itemsEast.put(itemDTO7.getName(), itemDTO7);
    itemsEast.put(itemDTO8.getName(), itemDTO8);
    east.setItems(itemsEast);
    RoomDTO west= new RoomDTO("Room west");
    west.setAnimals(Utils.loadZoo());
    Map<String, ItemDTO> itemsWest=new HashMap<>();
    ItemDTO itemDTO9 =new ItemDTO("item19","itemDiValore9",2);
    ItemDTO itemDTO10 =new ItemDTO("item10","itemDiValore10",3);
    itemsWest.put(itemDTO9.getName(), itemDTO9);
    itemsWest.put(itemDTO10.getName(), itemDTO10);
    west.setItems(itemsWest);
    EnumMap<Direction,RoomDTO> adjRooms=new EnumMap<>(Direction.class);
    adjRooms.put(Direction.NORTH,north);
    adjRooms.put(Direction.SOUTH,south);
    adjRooms.put(Direction.EAST,east);
    adjRooms.put(Direction.WEST,west);
    roomDTO.setAdjoiningRooms(adjRooms);
    north.setAdjoiningRooms(adjRooms);
    south.setAdjoiningRooms(adjRooms);
    east.setAdjoiningRooms(adjRooms);
    west.setAdjoiningRooms(adjRooms);
  }
}
