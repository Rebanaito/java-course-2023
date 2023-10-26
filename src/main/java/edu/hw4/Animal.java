package edu.hw4;

import java.util.*;

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

	public static List<Animal> sortByWeight(List<Animal> animals, int k) {
		return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).toList().subList(0, k);
	}

	public static Map<Animal.Type, Integer> countTypes(List<Animal> animals) {
		Map<Animal.Type, Integer> count = new HashMap<Animal.Type, Integer>();
		var iterator = animals.listIterator();
		while (iterator.hasNext()) {
			var a = iterator.next();
			var val = count.get(a.type);
			if (val != null) {
				count.put(a.type, val + 1);
			} else {
				count.put(a.type, 1);
			}
		}
		return count;
	}
}
