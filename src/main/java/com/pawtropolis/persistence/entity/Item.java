package com.pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column
  private String description;
  @Column(name = "required_slots")
  private Integer requiredSlots;

  @OneToOne
  @JoinColumn(name = "bag_id",referencedColumnName = "id")
  private Bag bag;

  @OneToOne
  @JoinColumn(name = "room_id",referencedColumnName = "id")
  private Room room;
}
