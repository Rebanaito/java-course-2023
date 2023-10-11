package edu.hw1;

import java.util.Arrays;

@SuppressWarnings("TypeName")
public final class Task_3 {
    private Task_3() {
    }

    public static boolean isNestable(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length == 0 || b.length == 0) {
            return false;
        }
        int minA = Arrays.stream(a).min().getAsInt();
        int minB = Arrays.stream(b).min().getAsInt();
        int maxA = Arrays.stream(a).max().getAsInt();
        int maxB = Arrays.stream(b).max().getAsInt();
        return (minA > minB && maxA < maxB);
    }
}
