package com.game;

import com.animals.Animal;
import com.map.Room;
import com.utils.UtilsGame;
import com.utils.UtilsZoo;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class GameController {
  private static final String COMMAND_GO="go";
  private static final String COMMAND_DROP="drop";
  private static final String COMMAND_GET="get";
  private static final String COMMAND_LOOK="look";
  private static final String COMMAND_BAG="bag";
  private static final String COMMAND_NOT_COMPLETELY="Command not completely";
  private static final String ITEM_NOT_FOUND="Item not found";
  private static final String NO_PLACE_AVAILABLE="No place available in your bag for this item";
  private static final String NO_ROOM_PRESENT="There isn't a room in this direction";
  private Room entry=new Room();
  private Player player=new Player();

  public GameController(){}
  public GameController(Room entry, Player player) {
    this.entry = entry;
    this.player = player;
  }

  public void runGame() {
    Room currentRoom = entry;
    boolean gameEnded = false;
    UtilsGame.fillGame(currentRoom,player);
    while(!gameEnded) {
      UtilsZoo.print("Where are you going to go?");
      UtilsZoo.print("Available commands: go<direction>(ex. go north)  look   bag   get<item>   drop<item>");
      System.out.print(">");
      Scanner sc = new Scanner(System.in);
      String command=sc.nextLine();
      if (command.startsWith(COMMAND_GO)){
        String direction=command.length()>3?command.substring(3):COMMAND_NOT_COMPLETELY;
        if (direction.equalsIgnoreCase(COMMAND_NOT_COMPLETELY))
          UtilsZoo.print(COMMAND_NOT_COMPLETELY);
        else if(currentRoom.getAdjoiningRooms().keySet().contains(direction)){
          currentRoom=currentRoom.getAdjoiningRooms().get(direction);
          command=COMMAND_LOOK;
        }else UtilsZoo.print(NO_ROOM_PRESENT);
      }else if (command.startsWith(COMMAND_GET)){
        String itemName=command.length()>4?command.substring(4):COMMAND_NOT_COMPLETELY;
        if (itemName.equalsIgnoreCase(COMMAND_NOT_COMPLETELY))
          UtilsZoo.print(COMMAND_NOT_COMPLETELY);
          else if(currentRoom.getItems().keySet().contains(itemName)){
            Item item=currentRoom.getItems().get(itemName);
            Integer totalSlotsAvailable=player.getBag().getAvailableSlots();
            Integer bagSize=player.getBag().getItems().size();
          if(bagSize < totalSlotsAvailable && totalSlotsAvailable-bagSize >= item.getRequiredSlots()) player.getBag().getItems().put(itemName,currentRoom.getItems().remove(itemName));
          else UtilsZoo.print(NO_PLACE_AVAILABLE);
        }else UtilsZoo.print(ITEM_NOT_FOUND);

      } else if (command.startsWith(COMMAND_DROP)) {
        String itemName=command.length()>5?command.substring(5):COMMAND_NOT_COMPLETELY;
        if (itemName.equalsIgnoreCase(COMMAND_NOT_COMPLETELY))
          UtilsZoo.print(COMMAND_NOT_COMPLETELY);
        else {
          AtomicReference<Boolean> isPresent= new AtomicReference<>(false);
          player.getBag().getItems().keySet().forEach(i-> {
            if (i.equalsIgnoreCase(itemName))
              isPresent.set(true);
          });
          if (isPresent.get()){
            currentRoom.getItems().put(itemName,player.getBag().getItems().remove(itemName));
          }else UtilsZoo.print(ITEM_NOT_FOUND);
        }
      }

      switch (command){
        case COMMAND_LOOK:
          List<Animal> animals=currentRoom.getAnimals();
          StringBuilder listOfAnimals=new StringBuilder();
          animals.forEach(a->listOfAnimals.append(a.getName()+"("+a.getSpecie()+"), "));
          UtilsZoo.print("You are in "+currentRoom.getName()+".\nItems: "+currentRoom.getItems()+"\nNPC: "+listOfAnimals);
          break;
        case COMMAND_BAG:
          UtilsZoo.print("In bag: "+player.getBag().toString());
          break;

      }
      if (command.equalsIgnoreCase("exit")) {
        gameEnded = true;
      }
    }
  }
}

