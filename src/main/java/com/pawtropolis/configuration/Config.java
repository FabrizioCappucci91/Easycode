package com.pawtropolis.configuration;

import com.pawtropolis.game.model.Player;
import com.pawtropolis.map.Room;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


  @Bean
  public Room getRoom(){
    return new Room("Main room");
  }

  @Bean
  public Player getPlayer() {
    return new Player("Player");
  }
}
