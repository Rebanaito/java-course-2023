package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Task6to10Test {
	@Test
	@DisplayName("Task 6 Test")
	void task6Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Edgar", Animal.Type.CAT, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Amy", Animal.Type.CAT, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergei", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, false));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		animals.add(new Animal("Jimbo", Animal.Type.CAT, Animal.Sex.M, 9, 19, 26, false));
		animals.add(new Animal("Myla", Animal.Type.DOG, Animal.Sex.F, 4, 35, 50, false));
		animals.add(new Animal("Peter", Animal.Type.SPIDER, Animal.Sex.M, 1, 3, 3, false));
		var heaviestAnimals = Animal.heaviestAnimal(animals);
		assertThat(heaviestAnimals.get(Animal.Type.CAT).name()).isEqualTo("Edgar");
		assertThat(heaviestAnimals.get(Animal.Type.SPIDER).name()).isEqualTo("Peter");
	}

	@Test
	@DisplayName("Task 7 Test")
	void task7Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Edgar", Animal.Type.CAT, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Amy", Animal.Type.CAT, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergei", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, false));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		animals.add(new Animal("Jimbo", Animal.Type.CAT, Animal.Sex.M, 9, 19, 26, false));
		animals.add(new Animal("Myla", Animal.Type.DOG, Animal.Sex.F, 4, 35, 50, false));
		animals.add(new Animal("Peter", Animal.Type.SPIDER, Animal.Sex.M, 1, 3, 3, false));
		var oldestAnimal = Animal.oldestAnimal(animals);
		assertThat(oldestAnimal.name()).isEqualTo("Jimbo");
	}

	@Test
	@DisplayName("Task 8 Test")
	void task8Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Edgar", Animal.Type.CAT, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Amy", Animal.Type.CAT, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergei", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, false));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		animals.add(new Animal("Jimbo", Animal.Type.CAT, Animal.Sex.M, 9, 19, 26, false));
		animals.add(new Animal("Myla", Animal.Type.DOG, Animal.Sex.F, 4, 35, 50, false));
		animals.add(new Animal("Peter", Animal.Type.SPIDER, Animal.Sex.M, 1, 3, 3, false));
		var heaviestAnimal = Animal.heaviestAnimalBelow(animals, 30);
		assertThat(heaviestAnimal.isPresent()).isTrue();
		assertThat(heaviestAnimal.get().name()).isEqualTo("Edgar");
		heaviestAnimal = Animal.heaviestAnimalBelow(animals, 15);
		assertThat(heaviestAnimal.isPresent()).isTrue();
		assertThat(heaviestAnimal.get().name()).isEqualTo("Chirp");
		heaviestAnimal = Animal.heaviestAnimalBelow(animals, 3);
		assertThat(heaviestAnimal.isPresent()).isFalse();
	}
}