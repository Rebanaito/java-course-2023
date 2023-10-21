package edu.hw3;

import java.util.Hashtable;

public class FrequencyDict {
    private FrequencyDict() {
    }

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
}
