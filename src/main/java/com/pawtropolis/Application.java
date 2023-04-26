package com.pawtropolis;

import com.pawtropolis.controller.GameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    ConfigurableApplicationContext app= SpringApplication.run(Application.class,args);
    GameController gameController= (GameController) app.getBean("GameController");
    gameController.runGame();
  }
}
