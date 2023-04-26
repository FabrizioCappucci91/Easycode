package com.pawtropolis.commands.domain;

import com.pawtropolis.commands.Command;
import com.pawtropolis.controller.GameController;
import com.pawtropolis.dto.game.ItemDTO;
import com.pawtropolis.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.pawtropolis.utils.Constants.ITEM_NOT_FOUND;

@Component
public class DropCommand extends Command {

  @Autowired
  private DropCommand(GameController gameController) {
    super(gameController);
  }

  @Override
  public void execute() {
    ItemDTO itemDTO = gameController.getPlayerDTO().removeItemFromBag(params.get(0));
    if (itemDTO !=null){
      gameController.getCurrentRoomDTO().addItem(itemDTO);
    }
    else Utils.print(ITEM_NOT_FOUND);
  }
}
