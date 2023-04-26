package com.pawtropolis.dto.zoo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AnimalWithTailDTO extends AnimalDTO {
	private double tailLength;

	protected AnimalWithTailDTO(String name, String favoriteFood, Integer age, LocalDate entryDate, Double weight, Double height, Double tailLength) {
		super(name, favoriteFood, age, entryDate, weight, height);
		this.tailLength=tailLength;
	}
}
