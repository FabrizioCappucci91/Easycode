package com.animals.model;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public abstract class AnimalWithWings extends Animal {
	private double wingspan;

	protected AnimalWithWings(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height,Double wingSpan) {
		super(name, favoriteFood, age, entryDate, weight, height);
		this.wingspan=wingSpan;
	}
}
