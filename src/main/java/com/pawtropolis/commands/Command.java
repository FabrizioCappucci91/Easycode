package com.pawtropolis.commands;

import com.pawtropolis.controller.GameController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public abstract class Command {
  @Autowired
  protected GameController gameController;
  @Getter@Setter
  protected List<String> params;

  @Autowired
  protected Command(GameController gameController){
    this.gameController =gameController;
    this.params=new ArrayList<>();
  }
  @Value("${command-class-method-name}")
  public abstract void execute();
}
