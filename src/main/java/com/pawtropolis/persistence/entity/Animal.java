package com.pawtropolis.persistence.entity;

import com.pawtropolis.converter.AnimalConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "specie",discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@SuperBuilder
@Data
public abstract class Animal {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String favoriteFood;
  @Column
  private Integer age;
  @Column(name = "entry_date")
  private LocalDate entryDate;
  @Column
  private Double weight;
  @Column
  private Double height;

  @OneToOne
  @JoinColumn(name = "room_id", referencedColumnName = "id")
  private Room room;

  public abstract AnimalConverter getconverter();
}
