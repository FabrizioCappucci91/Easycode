package com.pawtropolis.commands.domain;

import com.pawtropolis.commands.Command;
import com.pawtropolis.controller.GameController;
import com.pawtropolis.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand extends Command {
  @Autowired
  private ExitCommand(GameController gameController) {
    super(gameController);
  }

  @Override
  public void execute() {
    Utils.print("Bye bye");
    System.exit(0);
  }
}
