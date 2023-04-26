package com.pawtropolis.commands.domain;

import com.pawtropolis.commands.Command;
import com.pawtropolis.controller.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangeNameCommand extends Command {
  @Autowired
  private ChangeNameCommand(GameController gameController) {
    super(gameController);
  }

  @Override
  public void execute() {
    gameController.getPlayerDTO().setName(getParams().get(0));
  }
}
