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
}