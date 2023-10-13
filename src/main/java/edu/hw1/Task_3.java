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
        Arrays.sort(a);
        Arrays.sort(b);
        int minA = a[0];
        int minB = b[0];
        int maxA = a[a.length - 1];
        int maxB = b[b.length - 1];
        return (minA > minB && maxA < maxB);
    }
}
