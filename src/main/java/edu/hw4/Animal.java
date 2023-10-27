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

	public static Animal longestName(List<Animal> animals) {
		Comparator<Animal> nameLengthComparator = new Comparator<Animal>(){

			@Override
			public int compare(final Animal o1, final Animal o2){
				// let your comparator look up your car's color in the custom order
				return Integer.compare(o1.name.length(), o2.name.length());
			}
		};
		return animals.stream().max(nameLengthComparator).get();
	}

	public static Animal.Sex sexMajority(List<Animal> animals) {
		Animal.Sex majority = Sex.M;
		long males = animals.stream().filter(s -> s.sex == Sex.M).count();
		long females = animals.stream().filter(s -> s.sex == Sex.F).count();
		if (females > males) {
			majority = Sex.F;
		}
		return majority;
	}

	public static Map<Animal.Type, Animal> heaviestAnimal(List<Animal> animals) {
		Map<Animal.Type, Animal> heaviest = new HashMap<Animal.Type, Animal>();
		var iterator = animals.listIterator();
		while (iterator.hasNext()) {
			var a = iterator.next();
			var val = heaviest.get(a.type);
			if (val != null) {
				if (val.weight < a.weight) {
					val = a;
				}
				heaviest.put(a.type, val);
			} else {
				heaviest.put(a.type, a);
			}
		}
		return heaviest;
	}

	public static Animal oldestAnimal(List<Animal> animals) {
		return animals.stream().max(Comparator.comparingInt(Animal::age)).get();
	}

	public static Optional<Animal> heaviestAnimalBelow(List<Animal> animals, int k) {
		return animals.stream().filter(s -> s.height < k).max(Comparator.comparingInt(Animal::weight));
	}

	public static Integer pawsTotal(List<Animal> animals) {
		Integer count = 0;
		var iterator = animals.listIterator();
		while (iterator.hasNext()) {
			var a = iterator.next();
			count += a.paws();
		}
		return count;
	}

	public static List<Animal> pawsNotEqualAge(List<Animal> animals) {
		return animals.stream().filter(s -> s.paws() != s.age).toList();
	}

	public static List<Animal> largeBiters(List<Animal> animals) {
		return animals.stream().filter(s -> s.height > 100 && s.bites()).toList();
	}

	public static Integer heavierThan(List<Animal> animals, int weight) {
		return Math.toIntExact(animals.stream().filter(s -> s.weight > weight).count());
	}

	public static List<Animal> longNames(List<Animal> animals) {
		return animals.stream().filter(s -> s.name.split(" ").length > 2).toList();
	}
}
