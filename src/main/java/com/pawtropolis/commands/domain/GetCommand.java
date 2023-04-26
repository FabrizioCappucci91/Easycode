package com.pawtropolis.commands.domain;

import com.pawtropolis.commands.Command;
import com.pawtropolis.controller.GameController;
import com.pawtropolis.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.pawtropolis.utils.Constants.ITEM_NOT_FOUND;
import static com.pawtropolis.utils.Constants.NO_PLACE_AVAILABLE;

@Component
public class GetCommand extends Command {
  @Autowired
  private GetCommand(GameController gameController) {
    super(gameController);
  }

  @Override
  public void execute() {
    if(gameController.getCurrentRoomDTO().containsItem(params.get(0))){

      if(gameController.getPlayerDTO().addItemInBag(gameController.getCurrentRoomDTO().removeItem(params.get(0)))!=null){
        Utils.print(NO_PLACE_AVAILABLE);
      }
    }
    else Utils.print(ITEM_NOT_FOUND);
  }
}
