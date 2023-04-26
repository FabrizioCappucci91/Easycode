package com.pawtropolis.commands.domain;

import com.pawtropolis.commands.Command;
import com.pawtropolis.controller.GameController;
import com.pawtropolis.enums.Direction;
import com.pawtropolis.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.pawtropolis.utils.Constants.NO_ROOM_PRESENT;

@Component
public class GoCommand extends Command {
  @Autowired
  private GoCommand(GameController gameController) {
    super(gameController);
  }

  @Override
  public void execute() {
    if(gameController.getCurrentRoomDTO().goAdjoiningRoom(Direction.of(params.get(0)))!=null){
      gameController.setCurrentRoomDTO(gameController.getCurrentRoomDTO().goAdjoiningRoom(Direction.of(params.get(0))));
    }
    else Utils.print(NO_ROOM_PRESENT);
  }
}
