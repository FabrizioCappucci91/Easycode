package com.pawtropolis.commands.domain;

import com.pawtropolis.commands.Command;
import lombok.Getter;

import java.util.Arrays;
public enum CommandType {
  LOOK("look", LookCommand.class),
  BAG("bag", BagCommand.class),
  CHANGE_NAME("changeName", ChangeNameCommand.class),
  GO("go", GoCommand.class),
  GET("get", GetCommand.class),
  DROP("drop", DropCommand.class),
  EXIT("exit",ExitCommand.class),
  UNKNOWN_COMMAND(null, ExitCommand.class);

  @Getter
  private String type;
  @Getter
  private Class<?extends Command> aClass;
  CommandType(String type, Class<?extends Command> commandClass){
    this.type=type;
    aClass=commandClass;
  }

  public static CommandType fromString(String command){
    return Arrays.stream(values())
            .filter(commandType -> command.equalsIgnoreCase(commandType.getType()))
            .findAny()
            .orElse(null);
  }
}
