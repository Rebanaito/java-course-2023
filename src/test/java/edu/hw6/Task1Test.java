package edu.hw6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.*;

import java.io.File;
import java.sql.Time;

public class Task1Test {
	private final static String diskMapFile = "diskMap.txt";
	@Test
	@DisplayName("Basic test")
	void basicTest() {
		DiskMap diskMap = new DiskMap();

		assertThat(diskMap.size()).isEqualTo(0);
		diskMap.put("joe", "biden");
		assertThat(diskMap.size()).isEqualTo(1);
		diskMap.put("donald", "trump");
		assertThat(diskMap.size()).isEqualTo(2);
		assertThat(diskMap).containsKeys("joe", "donald");
		assertThat(diskMap).containsValues("biden", "trump");

		DiskMap newMap = new DiskMap();
		assertThat(newMap.size()).isEqualTo(2);
		assertThat(newMap).containsKeys("joe", "donald");
		assertThat(newMap).containsValues("biden", "trump");

		new File(diskMapFile).delete();
	}

	@Test
	@DisplayName("Duplicate test")
	void duplicateTest() {
		DiskMap diskMap = new DiskMap();

		diskMap.put("joe", "biden");
		diskMap.put("donald", "trump");
		diskMap.put("joe", "biden");
		assertThat(diskMap.size()).isEqualTo(2);

		new File(diskMapFile).delete();
	}

	@Test
	@DisplayName("Null key test")
	void nullKeyTest() {
		DiskMap diskMap = new DiskMap();

		diskMap.put(null, "trump");
		assertThat(diskMap.isEmpty()).isFalse();
		assertThat(diskMap).containsKeys((String)null);
		assertThat(diskMap).containsValues("trump");

		new File(diskMapFile).delete();
	}

	@Test
	@DisplayName("Null value test")
	void nullValueTest() {
		DiskMap diskMap = new DiskMap();

		diskMap.put("joe", null);
		assertThat(diskMap.isEmpty()).isFalse();
		assertThat(diskMap).containsValues((String)null);
		assertThat(diskMap).containsKeys("joe");

		new File(diskMapFile).delete();
	}

}
