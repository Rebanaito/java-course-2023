package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Task11to15Test {
	@Test
	@DisplayName("Task 11 Test")
	void task11Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Tigri", Animal.Type.CAT, Animal.Sex.M, 3, 120, 230, true));
		animals.add(new Animal("Amy", Animal.Type.CAT, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergei", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, false));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		animals.add(new Animal("Jimbo", Animal.Type.CAT, Animal.Sex.M, 9, 19, 26, false));
		animals.add(new Animal("Myla", Animal.Type.DOG, Animal.Sex.F, 4, 135, 250, false));
		animals.add(new Animal("Peter", Animal.Type.SPIDER, Animal.Sex.M, 1, 3, 3, false));
		var tallBiters = Animal.largeBiters(animals);
		assertThat(tallBiters.size()).isEqualTo(1);
		assertThat(tallBiters.get(0).name()).isEqualTo("Tigri");
	}

	@Test
	@DisplayName("Task 12 Test")
	void task12Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Tigri", Animal.Type.CAT, Animal.Sex.M, 3, 120, 230, true));
		animals.add(new Animal("Amy", Animal.Type.CAT, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergei", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, false));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		animals.add(new Animal("Jimbo", Animal.Type.CAT, Animal.Sex.M, 9, 19, 26, false));
		animals.add(new Animal("Myla", Animal.Type.DOG, Animal.Sex.F, 4, 135, 250, false));
		animals.add(new Animal("Peter", Animal.Type.SPIDER, Animal.Sex.M, 1, 3, 3, false));
		var count = Animal.heavierThan(animals, 250);
		assertThat(count).isEqualTo(0);
		count = Animal.heavierThan(animals, 200);
		assertThat(count).isEqualTo(2);
		count = Animal.heavierThan(animals, 15);
		assertThat(count).isEqualTo(4);
	}

	@Test
	@DisplayName("Task 13 Test")
	void task13Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("John Doe", Animal.Type.CAT, Animal.Sex.M, 3, 120, 230, true));
		animals.add(new Animal("Amy", Animal.Type.CAT, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergeev Sergei Sergeevich", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, false));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		animals.add(new Animal("Jimbo Baggins", Animal.Type.CAT, Animal.Sex.M, 9, 19, 26, false));
		animals.add(new Animal("Myla", Animal.Type.DOG, Animal.Sex.F, 4, 135, 250, false));
		var longNames = Animal.longNames(animals);
		assertThat(longNames.size()).isEqualTo(1);
		assertThat(longNames.get(0).type()).isEqualTo(Animal.Type.SPIDER);
	}
}