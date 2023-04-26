package com.pawtropolis.converter;

import com.pawtropolis.dto.game.PlayerDTO;
import com.pawtropolis.persistence.entity.Player;
import org.springframework.beans.factory.annotation.Value;

public class PlayerConverter {

  @Value("${converter-class-method-name-convert-to-dto}")
  public PlayerDTO convert2DTO(Player obj){
    if (obj==null) return null;

    return PlayerDTO.builder()
            .id(obj.getId())
            .bagDTO(BagConverter.convert2DTO(obj.getBag()))
            .lifePoints(obj.getLifePoints())
            .name(obj.getName())
            .build();
  }

  @Value("${converter-class-method-name-convert-to-entity}")
  public Player convert2Entity(PlayerDTO obj){
    if (obj==null) return null;

    return Player.builder()
            .id(obj.getId())
            .bag(BagConverter.convert2Entity(obj.getBagDTO()))
            .lifePoints(obj.getLifePoints())
            .name(obj.getName())
            .build();
  }


}
