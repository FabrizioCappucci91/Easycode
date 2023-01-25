package com.game;

import com.console.InputController;
import com.game.model.Player;
import com.map.Room;
import com.utils.Utils;
import com.utils.UtilsGame;

import static com.utils.Constants.*;

public class GameController {

  private Room currentRoom=new Room("Main room");
  private final Player player=new Player("Player1");

  public void runGame() {
    GameService gameService= new GameService();
    boolean gameEnded = false;
    UtilsGame.fillGame(currentRoom);
    System.out.print("Insert player's name: ");
    String playerName = InputController.readString();
    player.setName(playerName);
    while(!gameEnded) {
      Utils.print(playerName +" Where are you going to go?");
      Utils.print("Available commands: go<direction>(ex. go north)  look   bag   get<item>   drop<item>");
      System.out.print(">");
      String command=InputController.readString();
      if (command.startsWith(COMMAND_GO)){
        currentRoom= gameService.goCommand(currentRoom,command);
      }
      else if (command.startsWith(COMMAND_GET)){
        gameService.getCommand(currentRoom,player,command);
      }
      else if (command.startsWith(COMMAND_DROP)) {
        String itemName=command.length()>COMMAND_DROP.length()+1?command.substring(COMMAND_DROP.length()+1): COMMAND_NOT_COMPLETE;
        gameService.dropCommand(itemName,player,currentRoom);
      }
      else if (command.startsWith(COMMAND_LOOK)) {
        Utils.print(gameService.lookCommand(currentRoom));
      }
      else if (command.startsWith(COMMAND_BAG)) {
        Utils.print(gameService.bagCommand(player));
      }
      if (command.equalsIgnoreCase("exit")) {
        gameEnded = true;
      }
    }
  }
}

