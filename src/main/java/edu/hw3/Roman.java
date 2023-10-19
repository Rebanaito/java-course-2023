package edu.hw3;

public class Roman {
	public static String convertToRoman(int num) {
		StringBuilder roman = new StringBuilder();
		int[] decimals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		for (int i = 0; i < decimals.length; i++) {
			while (num >= decimals[i]) {
				num -= decimals[i];
				roman.append(numerals[i]);
			}
		}
		return roman.toString();
	}
}