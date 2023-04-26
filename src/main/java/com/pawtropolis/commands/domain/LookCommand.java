package com.pawtropolis.commands.domain;

import com.pawtropolis.commands.Command;
import com.pawtropolis.controller.GameController;
import com.pawtropolis.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends Command {
  @Autowired
  private LookCommand(GameController gameController) {
    super(gameController);
  }

  @Override
  public void execute() {
    String listOfAnimals= gameController.getCurrentRoomDTO().showAnimals();
    String listOfItems= gameController.getCurrentRoomDTO().showItems();
    if (listOfAnimals!=null && !listOfAnimals.isEmpty()) {
      listOfAnimals=listOfAnimals.substring(1,listOfAnimals.length() - 1);
    }
    if (listOfItems!=null && !listOfItems.isEmpty()) {
      listOfItems=listOfItems.substring(1,listOfItems.length() - 1);
    }
    Utils.print("You are in " + gameController.getCurrentRoomDTO().getName() + ".\nItems: [" + listOfItems + "]\nNPC: " + listOfAnimals);
  }
}
