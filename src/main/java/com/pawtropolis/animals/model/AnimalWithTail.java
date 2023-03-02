package com.pawtropolis.animals.model;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public abstract class AnimalWithTail extends Animal {
	private double tailLength;

	protected AnimalWithTail(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height,Double tailLength) {
		super(name, favoriteFood, age, entryDate, weight, height);
		this.tailLength=tailLength;
	}
}
