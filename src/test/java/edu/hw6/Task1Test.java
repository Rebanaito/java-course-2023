package edu.hw6;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

public class Task1Test {
	@Test
	@DisplayName("DiskMap test")
	void diskMapTest() {
		DiskMap diskMap = new DiskMap();

		assertThat(diskMap.size()).isEqualTo(0);
		diskMap.put("joe", "biden");
		assertThat(diskMap.size()).isEqualTo(1);
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

		new File("diskMap.txt").delete();
	}
}
