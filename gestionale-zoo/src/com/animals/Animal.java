package com.animals;

import java.time.LocalDate;
import java.util.Objects;

public class Animal {
  private String name;
  private String favoriteFood;
  private Integer age;
  private LocalDate entryDate;
  private Double weight;
  private Double height;
  private Double lenght;
  private SpecieAnimale specie;

  public Animal(){}

  public Animal(String nome, String ciboPreferito, Integer eta, LocalDate dataIngresso, Double peso, Double altezza, Double lunghezza, SpecieAnimale tipoSpecie){
    name=nome;
    favoriteFood=ciboPreferito;
    age=eta;
    entryDate=dataIngresso;
    weight=peso;
    height=altezza;
    lenght=lunghezza;
    specie=tipoSpecie;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setFavoriteFood(String favoriteFood) {
    this.favoriteFood = favoriteFood;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setEntryDate(LocalDate entryDate) {
    this.entryDate = entryDate;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public void setLenght(Double lenght) {
    this.lenght = lenght;
  }

  public void setSpecie(SpecieAnimale specie) {
    this.specie = specie;
  }

  public String getName() {
    return name;
  }

  public String getFavoriteFood() {
    return favoriteFood;
  }

  public Integer getAge() {
    return age;
  }

  public LocalDate getEntryDate() {
    return entryDate;
  }

  public Double getWeight() {
    return weight;
  }

  public Double getHeight() {
    return height;
  }

  public Double getLenght() {
    return lenght;
  }

  public SpecieAnimale getSpecie() {
    return specie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Animal animale = (Animal) o;
    return Objects.equals(name, animale.name) && Objects.equals(favoriteFood, animale.favoriteFood) && Objects.equals(age, animale.age) && Objects.equals(entryDate, animale.entryDate) && Objects.equals(weight, animale.weight) && Objects.equals(height, animale.height) && Objects.equals(lenght, animale.lenght) && specie == animale.specie;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, favoriteFood, age, entryDate, weight, height, lenght, specie);
  }

  @Override
  public String toString() {
    if (specie.equals(SpecieAnimale.AQUILA))
    return "\n" +
            "nome='" + name + '\'' +
            ", cibo preferito='" + favoriteFood + '\'' +
            ", età='" + age + '\'' +
            ", data ingresso zoo='" + entryDate + '\'' +
            ", peso='" + weight + '\'' +
            ", altezza='" + height + '\'' +
            ", apertura alare='" + lenght +"cm"+ '\'' +
            ", specie=" + specie +
            '\n';
    else return  "\n" +
            "nome='" + name + '\'' +
            ", cibo preferito='" + favoriteFood + '\'' +
            ", età='" + age + '\'' +
            ", data ingresso zoo='" + entryDate + '\'' +
            ", peso='" + weight + '\'' +
            ", altezza='" + height + '\'' +
            ", lunghezza coda='" + lenght +"cm"+ '\'' +
            ", specie=" + specie +
            '\n';
  }
}
