package com.pawtropolis.persistence.entity;

import com.pawtropolis.enums.Direction;
import jakarta.persistence.*;
import lombok.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Transient
  private List<Animal> animals;

  @Transient
  private Map<String, Item> items;

  @ManyToMany
  @JoinTable(
          name = "linked_rooms",
          joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "linked_room_id", referencedColumnName = "id")
  )
  @MapKeyEnumerated(EnumType.STRING)
  @MapKeyColumn(name = "direction")
  private EnumMap<Direction, Room> adjoiningRooms;

}
