package com.game;

import com.animals.model.Animal;
import com.game.model.Item;
import com.game.model.Player;
import com.map.Direction;
import com.map.Room;
import com.utils.Utils;

import java.util.List;

import static com.utils.Constants.*;

public class GameService {

  public Room goCommand(Room currentRoom,String command){
    String direction=command.length()>COMMAND_GO.length()+1?command.substring(COMMAND_GO.length()+1): COMMAND_NOT_COMPLETE;

    if (direction.equalsIgnoreCase(COMMAND_NOT_COMPLETE))
      Utils.print(COMMAND_NOT_COMPLETE);

    else if(currentRoom.getAdjoiningRooms().containsKey(Direction.of(direction))){
      currentRoom=currentRoom.getAdjoiningRooms().get(Direction.of(direction));
      return currentRoom;
    }
    else Utils.print(NO_ROOM_PRESENT);
    return null;
  }

  public void getCommand(Room currentRoom, Player player, String command) {
    String itemName=command.length()>COMMAND_GET.length()+1?command.substring(COMMAND_GET.length()+1): COMMAND_NOT_COMPLETE;

    if (itemName.equalsIgnoreCase(COMMAND_NOT_COMPLETE))
      Utils.print(COMMAND_NOT_COMPLETE);

    else if(currentRoom.getItems().containsKey(itemName)){

      if(player.addItemInBag(currentRoom.getItems().remove(itemName))!=null) Utils.print(NO_PLACE_AVAILABLE);

    }else Utils.print(ITEM_NOT_FOUND);

  }

  public void dropCommand(String itemName,Player player,Room currentRoom){
    if (itemName.equalsIgnoreCase(COMMAND_NOT_COMPLETE))
      Utils.print(COMMAND_NOT_COMPLETE);
    else {
      Item item=player.removeItemFromBag(itemName);
      if (item!=null){
        currentRoom.getItems().put(itemName,item);
      }
      else Utils.print(ITEM_NOT_FOUND);
    }
  }

  public String lookCommand(Room currentRoom){
    List<Animal> animals = currentRoom.getAnimals();
    StringBuilder listOfAnimals = new StringBuilder();
    StringBuilder listOfItems = new StringBuilder();
    animals.forEach(a -> listOfAnimals.append(a.getName()).append("(").append(a.getClass().getSimpleName()).append("),"));
    currentRoom.getItems().forEach((s, item) -> listOfItems.append(item.getName()).append(","));
    if (!listOfAnimals.isEmpty()) {
      listOfAnimals.deleteCharAt(listOfAnimals.length() - 1);
    }
    if (!listOfItems.isEmpty()) {
      listOfItems.deleteCharAt(listOfItems.length() - 1);
    }
    return "You are in " + currentRoom.getName() + ".\nItems: " + listOfItems + "\nNPC: " + listOfAnimals;
  }

  public String bagCommand(Player player){
    return "In bag: " + player.getItemsInBag();
  }
}
