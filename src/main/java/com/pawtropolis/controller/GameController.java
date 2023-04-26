package com.pawtropolis.controller;

import com.pawtropolis.commands.Command;
import com.pawtropolis.commands.CommandGenerator;
import com.pawtropolis.console.InputController;
import com.pawtropolis.dto.game.PlayerDTO;
import com.pawtropolis.dto.map.RoomDTO;
import com.pawtropolis.persistence.entity.Animal;
import com.pawtropolis.persistence.entity.Eagle;
import com.pawtropolis.service.AnimalService;
import com.pawtropolis.utils.Utils;
import com.pawtropolis.utils.UtilsGame;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import static com.pawtropolis.utils.Constants.UNKNOWN_COMMAND;
@Controller("GameController")
@Slf4j
public class GameController {

  @Getter@Setter
  private RoomDTO currentRoomDTO;
  @Getter
  private PlayerDTO playerDTO;
  private CommandGenerator commandGenerator;

  @Value("${command-class-method-name}")
  private String methodName;

  @Autowired
  private AnimalService animalService;

  @Autowired
  public GameController(PlayerDTO playerDTO, CommandGenerator commandGenerator){
    this.currentRoomDTO =new RoomDTO("Main Room");
    this.playerDTO = playerDTO;
    this.commandGenerator=commandGenerator;
  }
  public void runGame() {
    Utils.print("Welcome to Pawtropolis.");
    Animal animal=new Eagle();
    animalService.saveAnimal(animal);
    log.info(animalService.getAllAnimals().toString());
    UtilsGame.fillGame(currentRoomDTO);
    while (true) {
      showCommands();
      Command command = commandGenerator.createCommand(InputController.readString());
      if (command != null) {
        Method[] methods=command.getClass().getDeclaredMethods();
        Optional<Method> methodOptional  = Arrays.stream(methods).filter(a -> a.getName().equalsIgnoreCase(methodName)).findFirst();
        if (methodOptional.isPresent()) {
          try {
            methodOptional.get().invoke(command);
          } catch (InvocationTargetException | IllegalAccessException e) {
            Utils.print(UNKNOWN_COMMAND);
          }
        }
      }
      else {
          Utils.print(UNKNOWN_COMMAND);
      }
    }
  }
  private void showCommands(){
    Utils.print(playerDTO.getName() +",What do you want to do?");
    Utils.print("Available commands: go<direction>(ex. go north)  look   bag   get<item>   drop<item>  changeName<name>  exit");
    log.info(">");
  }

}