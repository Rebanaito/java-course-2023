package edu.hw3;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class FrequencyDict {
	public static <T> Hashtable<T, Integer> freqDict(T[] data) {
		Hashtable<T, Integer> table = new Hashtable<>();
		for (int i = 0; i < data.length; i++) {
			Integer value = table.get(data[i]);
			if (value == null) {
				table.put(data[i], 1);
			} else {
				table.put(data[i], value + 1);
			}
		}
		return table;
	}

	public static void main(String[] args) {
		var table = freqDict(new String[] {"a", "bb", "a", "bb"});
		table.forEach((key, value)
				-> System.out.println("Key: " + key + "\tName: " + value));
	}
}