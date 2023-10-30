package edu.hw3;

import java.util.Hashtable;

public class FrequencyDict {
    private FrequencyDict() {
    }

    public static <T> Hashtable<T, Integer> freqDict(T[] data) {
        Hashtable<T, Integer> table = new Hashtable<>();
        for (int i = 0; i < data.length; i++) {
            table.put(data[i], table.getOrDefault(data[i], 0) + 1);
        }
        return table;
    }
}
