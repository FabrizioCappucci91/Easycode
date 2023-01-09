package com.alten.model;

import com.alten.model.enums.SpecieAnimale;

import java.util.Objects;

public class Animale {
  private String name;
  private String favoriteFood;
  private Integer age;
  private String entryDate;
  private Integer weight;
  private Integer height;
  private Integer lenght;
  private SpecieAnimale specie;

  public Animale(){}

  public Animale(String nome,String ciboPreferito,Integer eta,String dataIngresso,Integer peso,Integer altezza,Integer lunghezza,SpecieAnimale tipoSpecie){
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

  public void setEntryDate(String entryDate) {
    this.entryDate = entryDate;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public void setLenght(Integer lenght) {
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

  public String getEntryDate() {
    return entryDate;
  }

  public Integer getWeight() {
    return weight;
  }

  public Integer getHeight() {
    return height;
  }

  public Integer getLenght() {
    return lenght;
  }

  public SpecieAnimale getSpecie() {
    return specie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Animale animale = (Animale) o;
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
