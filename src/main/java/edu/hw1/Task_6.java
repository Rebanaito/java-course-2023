package edu.hw1;

import java.util.Arrays;

@SuppressWarnings("TypeName")
public final class Task_6 {
    private Task_6() {
    }

    private static boolean sameDigits(int n) {
        String str = Utils.itoa(n);
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[0]) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("MagicNumber")
    public static int countK(int num) {
        int n = num;
        if (n < 1001 || n > 9999) {
            return -1;
        }
        if (sameDigits(n)) {
            return -1;
        }
        int count = 0;
        while (n != 6174) {
            String str = Utils.itoa(n);
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            int right = Utils.atoi(chars);
            int left = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                left = left * 10 + (chars[i] - '0');
            }
            n = left - right;
            if (n < 1000) {
                n *= 10;
            }
            count++;
        }
        return count;
    }
}
