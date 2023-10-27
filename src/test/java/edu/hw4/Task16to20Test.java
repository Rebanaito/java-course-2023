package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Task16to20Test {
	@Test
	@DisplayName("Task 16 Test")
	void task16Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Jamie", Animal.Type.CAT, Animal.Sex.F, 3, 20, 30, true));
		animals.add(new Animal("William", Animal.Type.CAT, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Jane", Animal.Type.CAT, Animal.Sex.F, 3, 20, 30, true));
		animals.add(new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Edgar", Animal.Type.CAT, Animal.Sex.M, 3, 20, 30, true));

		animals.add(new Animal("Bark", Animal.Type.DOG, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Lassie", Animal.Type.DOG, Animal.Sex.F, 3, 20, 30, true));
		animals.add(new Animal("Jimbo", Animal.Type.DOG, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Stark", Animal.Type.DOG, Animal.Sex.F, 3, 20, 30, true));
		animals.add(new Animal("Eddie", Animal.Type.DOG, Animal.Sex.M, 3, 20, 30, true));

		var sorted = Animal.sortByTypeSexName(animals);
		assertThat(sorted.get(0).name()).isEqualTo("Barsik");
		assertThat(sorted.get(4).name()).isEqualTo("Jane");
		assertThat(sorted.get(5).name()).isEqualTo("Bark");
		assertThat(sorted.get(9).name()).isEqualTo("Stark");
	}

	@Test
	@DisplayName("Task 17 Test")
	void task17Test() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Edgar", Animal.Type.DOG, Animal.Sex.M, 3, 20, 30, true));
		animals.add(new Animal("Amy", Animal.Type.DOG, Animal.Sex.F, 7, 17, 20, true));
		animals.add(new Animal("Sergei", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, true));
		animals.add(new Animal("Chirp", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 12, false));
		animals.add(new Animal("Jimbo", Animal.Type.CAT, Animal.Sex.M, 9, 19, 26, false));
		animals.add(new Animal("Myla", Animal.Type.DOG, Animal.Sex.F, 4, 35, 50, false));
		animals.add(new Animal("Peter", Animal.Type.SPIDER, Animal.Sex.M, 1, 3, 3, false));
		var spidersBad = Animal.spidersVsDogsBites(animals);
		assertThat(spidersBad).isFalse();
		animals.add(new Animal("Dave", Animal.Type.SPIDER, Animal.Sex.M, 1, 3, 3, true));
		animals.add(new Animal("Steve", Animal.Type.SPIDER, Animal.Sex.M, 1, 3, 3, true));
		spidersBad = Animal.spidersVsDogsBites(animals);
		assertThat(spidersBad).isTrue();
	}

	@Test
	@DisplayName("Task 18 Test")
	void task18Test() {
		int n = 3;
		List<Animal>[] animals = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			animals[i] = new ArrayList<Animal>();
		}
		animals[0].add(new Animal("Pupa", Animal.Type.FISH, Animal.Sex.F, 3, 20, 19, false));
		animals[0].add(new Animal("Loopa", Animal.Type.FISH, Animal.Sex.F, 3, 20, 30, false));
		animals[0].add(new Animal("Jim", Animal.Type.FISH, Animal.Sex.M, 3, 20, 24, false));
		animals[0].add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.M, 3, 20, 27, false));

		animals[1].add(new Animal("Jill", Animal.Type.FISH, Animal.Sex.F, 3, 20, 19, false));
		animals[1].add(new Animal("Jewel", Animal.Type.DOG, Animal.Sex.F, 3, 20, 35, false));
		animals[1].add(new Animal("Tim", Animal.Type.CAT, Animal.Sex.M, 3, 20, 32, false));
		animals[1].add(new Animal("Rob", Animal.Type.FISH, Animal.Sex.M, 3, 20, 25, false));

		animals[2].add(new Animal("Jill", Animal.Type.DOG, Animal.Sex.F, 3, 20, 40, false));
		animals[2].add(new Animal("Jewel", Animal.Type.DOG, Animal.Sex.F, 3, 20, 36, false));
		animals[2].add(new Animal("Tim", Animal.Type.CAT, Animal.Sex.M, 3, 20, 33, false));
		animals[2].add(new Animal("Rob", Animal.Type.DOG, Animal.Sex.M, 3, 20, 42, false));

		var bigBoy = Animal.heaviestFish(animals);
		assertThat(bigBoy.isPresent()).isTrue();
		assertThat(bigBoy.get().name()).isEqualTo("Loopa");

		List<Animal>[] scuffed = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			scuffed[i] = new ArrayList<Animal>();
		}
		scuffed[0].add(new Animal("Jill", Animal.Type.DOG, Animal.Sex.F, 3, 20, 40, false));
		scuffed[1].add(new Animal("Jewel", Animal.Type.DOG, Animal.Sex.F, 3, 20, 36, false));
		scuffed[2].add(new Animal("Tim", Animal.Type.CAT, Animal.Sex.M, 3, 20, 33, false));
		scuffed[2].add(new Animal("Rob", Animal.Type.DOG, Animal.Sex.M, 3, 20, 42, false));

		bigBoy = Animal.heaviestFish(scuffed);
		assertThat(bigBoy.isPresent()).isFalse();
	}
}