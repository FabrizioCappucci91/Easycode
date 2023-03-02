package com.pawtropolis.game;

import com.pawtropolis.game.model.Item;
import com.pawtropolis.game.model.Player;
import com.pawtropolis.map.Direction;
import com.pawtropolis.map.Room;
import com.pawtropolis.utils.Utils;
import com.pawtropolis.utils.UtilsGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pawtropolis.utils.Constants.*;
@Service
public class GameService {

  private Room currentRoom;
  private Player player;

  @Autowired
  private GameService(Room currentRoom, Player player){
    this.currentRoom = currentRoom;
    this.player=player;
  }

  public String setPlayerName(String command){
    String name=command.length()>COMMAND_CHANGE.length()+1?command.substring(COMMAND_CHANGE.length()+1): COMMAND_NOT_COMPLETE;
    player.setName(name);
    return name;
  }

  public Room goCommand(String command){
    String direction=command.length()>COMMAND_GO.length()+1?command.substring(COMMAND_GO.length()+1): COMMAND_NOT_COMPLETE;

    if (direction.equalsIgnoreCase(COMMAND_NOT_COMPLETE)){
      Utils.print(COMMAND_NOT_COMPLETE);
    }
    else if(currentRoom.goAdjoiningRoom(Direction.of(direction))!=null){
      currentRoom=currentRoom.goAdjoiningRoom(Direction.of(direction));
      return currentRoom;
    }

    else Utils.print(NO_ROOM_PRESENT);
    return null;
  }

  public void getCommand(String command) {
    String itemName=command.length()>COMMAND_GET.length()+1?command.substring(COMMAND_GET.length()+1): COMMAND_NOT_COMPLETE;

    if (itemName.equalsIgnoreCase(COMMAND_NOT_COMPLETE))
      Utils.print(COMMAND_NOT_COMPLETE);

    else if(currentRoom.containsItem(itemName)){

      if(player.addItemInBag(currentRoom.removeItem(itemName))!=null){
        Utils.print(NO_PLACE_AVAILABLE);
      }

    }else Utils.print(ITEM_NOT_FOUND);

  }

  public void dropCommand(String itemName){
    if (itemName.equalsIgnoreCase(COMMAND_NOT_COMPLETE))
      Utils.print(COMMAND_NOT_COMPLETE);
    else {
      Item item=player.removeItemFromBag(itemName);
      if (item!=null){
        currentRoom.addItem(item);
      }
      else Utils.print(ITEM_NOT_FOUND);
    }
  }

  public String lookCommand(){
    String listOfAnimals=currentRoom.showAnimals();
    String listOfItems=currentRoom.showItems();
    if (!listOfAnimals.isEmpty()) {
      listOfAnimals=listOfAnimals.substring(1,listOfAnimals.length() - 1);
    }
    if (!listOfItems.isEmpty()) {
      listOfItems=listOfItems.substring(1,listOfItems.length() - 1);
    }
    return "You are in " + currentRoom.getName() + ".\nItems: " + listOfItems + "\nNPC: " + listOfAnimals;
  }

  public String bagCommand(){
    return "In bag: " + player.getItemsInBag();
  }

  public void fillGame() {
    UtilsGame.fillGame(currentRoom);
  }
}
