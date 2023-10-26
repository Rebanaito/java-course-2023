package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Task1to5Test {
	@Test
	@DisplayName("Task 1 test")
	void task1Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Edgar", Animal.Type.DOG, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Amy", Animal.Type.CAT, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergei", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, false));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		var sortedByHeight = Animal.sortByHeight(animals);
		assertThat(sortedByHeight.get(0).type()).isEqualTo(Animal.Type.SPIDER);
		assertThat(sortedByHeight.get(sortedByHeight.size()-1).name()).isEqualTo("Edgar");
	}

	@Test
	@DisplayName("Task 2 test")
	void task2Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Edgar", Animal.Type.DOG, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Amy", Animal.Type.CAT, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergei", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, false));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		var sortedByWeight = Animal.sortByWeight(animals, 3);
		assertThat(sortedByWeight.size()).isEqualTo(3);
		assertThat(sortedByWeight.get(0).type()).isEqualTo(Animal.Type.DOG);
		assertThat(sortedByWeight.get(sortedByWeight.size()-1).name()).isEqualTo("Chirp");
	}

	@Test
	@DisplayName("Task 2 test")
	void task3Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Edgar", Animal.Type.CAT, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Amy", Animal.Type.CAT, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergei", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, false));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		animals.add(new Animal("Jimbo", Animal.Type.CAT, Animal.Sex.M, 9, 19, 26, false));
		animals.add(new Animal("Myla", Animal.Type.DOG, Animal.Sex.F, 4, 35, 50, false));
		animals.add(new Animal("Peter", Animal.Type.SPIDER, Animal.Sex.M, 1, 3, 2, false));
		var count = Animal.countTypes(animals);
		assertThat(count.size()).isEqualTo(4);
		assertThat(count.get(Animal.Type.CAT)).isEqualTo(3);
		assertThat(count.get(Animal.Type.DOG)).isEqualTo(1);
		assertThat(count.get(Animal.Type.BIRD)).isEqualTo(1);
		assertThat(count.get(Animal.Type.SPIDER)).isEqualTo(2);
	}
}