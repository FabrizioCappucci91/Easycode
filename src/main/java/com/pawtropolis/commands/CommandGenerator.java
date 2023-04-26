package com.pawtropolis.commands;

import com.pawtropolis.commands.domain.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

@Component
public class CommandGenerator {
  private ApplicationContext applicationContext;
  private EnumMap<CommandType,Command> commandEnumMap;

  @Autowired
  private CommandGenerator(ApplicationContext applicationContext){
    this.applicationContext =applicationContext;

  }
  private void createMapCommands(){
    commandEnumMap= new EnumMap<>(CommandType.class);
    Arrays.stream(CommandType.values()).forEach(c->commandEnumMap.put(c, applicationContext.getBean(c.getAClass())));
  }
  public Command createCommand(String command) {
    List<String> commands = Arrays.asList(command.split(" "));
    if (commandEnumMap == null) createMapCommands();

    Command obj = commandEnumMap.get(CommandType.fromString(commands.get(0)));
    if (obj!=null) {
      if (commands.size() > 1) {
        StringBuilder stringBuilderCommands = new StringBuilder();
        commands.stream().skip(1).forEach(c -> stringBuilderCommands.append(c).append(" "));
        obj.getParams().add(stringBuilderCommands.deleteCharAt(stringBuilderCommands.length() - 1).toString());
      }
    }
    return obj;
  }
}
