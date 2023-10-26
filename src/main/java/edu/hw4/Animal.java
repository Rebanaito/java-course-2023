package edu.hw4;

import java.util.Comparator;
import java.util.List;

public record Animal(
		String name,
		Type type,
		Sex sex,
		int age,
		int height,
		int weight,
		boolean bites
) {
	enum Type {
		CAT, DOG, BIRD, FISH, SPIDER
	}

	enum Sex {
		M, F
	}

	public int paws() {
		return switch (type) {
			case CAT, DOG -> 4;
			case BIRD -> 2;
			case FISH -> 0;
			case SPIDER -> 8;
		};
	}

	public static List<Animal> sortByHeight(List<Animal> animals) {
		return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
	}
}
