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
}