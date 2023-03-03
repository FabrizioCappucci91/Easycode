package com.pawtropolis.game;

import com.pawtropolis.console.InputController;
import com.pawtropolis.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import static com.pawtropolis.utils.Constants.*;
@Controller("GameController")
public class GameController {

  private GameService gameService;
  @Autowired
  public GameController(GameService gameService){
    this.gameService=gameService;
  }
  public void runGame() {
    Utils.print("Welcome to Pawtropolis.");
    boolean gameEnded = false;
    gameService.fillGame();
    while(!gameEnded) {
      gameService.showCommands();
      String command=InputController.readString();
      if (command.startsWith(COMMAND_CHANGE)){
        String name=gameService.setPlayerName(command);
        Utils.print("Name changed successfully, "+name);
      }
      if (command.startsWith(COMMAND_GO)){
        gameService.goCommand(command);
      }
      if (command.startsWith(COMMAND_GET)){
        gameService.getCommand(command);
      }
      if (command.startsWith(COMMAND_DROP)) {
        String itemName=command.length()>COMMAND_DROP.length()+1?command.substring(COMMAND_DROP.length()+1): COMMAND_NOT_COMPLETE;
        gameService.dropCommand(itemName);
      }
      if (command.startsWith(COMMAND_LOOK)) {
        Utils.print(gameService.lookCommand());
      }
      if (command.startsWith(COMMAND_BAG)) {
        Utils.print(gameService.bagCommand());
      }
      if (command.equalsIgnoreCase("exit")) {
        gameEnded = true;
        Utils.print("Bye bye");
      }
    }
  }
}

