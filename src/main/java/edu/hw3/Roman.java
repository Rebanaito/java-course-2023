package edu.hw3;

public class Roman {
    private Roman() {
    }

    private final static int[] DECIMALS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String convertToRoman(int num) {
        int n = num;
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < DECIMALS.length; i++) {
            while (n >= DECIMALS[i]) {
                n -= DECIMALS[i];
                roman.append(NUMERALS[i]);
            }
        }
        return roman.toString();
    }
}
