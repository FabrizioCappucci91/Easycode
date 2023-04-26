package com.pawtropolis.dto.zoo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public abstract class AnimalWithWingsDTO extends AnimalDTO {
	private double wingspan;
	protected AnimalWithWingsDTO(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height, Double wingSpan) {
		super(name, favoriteFood, age, entryDate, weight, height);
		this.wingspan=wingSpan;
	}
}
