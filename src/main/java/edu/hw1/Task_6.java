package edu.hw1;

import java.util.Arrays;

@SuppressWarnings("TypeName")
public final class Task_6 {
    private Task_6() {
    }

    private final static int MIN_VALUE = 1001;
    private final static int MAX_VALUE = 9999;
    private final static int KAPREKAR = 6174;

    @SuppressWarnings("MagicNumber")
    public static int countK(int num) {
        int n = num;
        if (n < MIN_VALUE || n > MAX_VALUE) {
            return -1;
        }
        if (sameDigits(n)) {
            return -1;
        }
        int count = 0;
        while (n != KAPREKAR) {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            int right = Integer.parseInt(String.valueOf(chars));
            int left = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                left = left * 10 + (chars[i] - '0');
            }
            n = left - right;
            if (n < MIN_VALUE - 1) {
                n *= 10;
            }
            count++;
        }
        return count;
    }

    private static boolean sameDigits(int n) {
        String str = Integer.toString(n);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
