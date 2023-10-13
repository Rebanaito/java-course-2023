package edu.hw1;

@SuppressWarnings("TypeName")
public final class Task_5 {

    private Task_5() {
    }

    private final static int INT_MIN = -2147483648;
    private final static int ASCII_DIGITS_SHIFT = 48;
    private final static int TEN = 10;

    public static boolean isPalindromeDescendant(int num) {
        if ((num > 0 && num < TEN) || (num < 0 && num > -TEN)) {
            return true;
        }
        if (num == INT_MIN) {
            return false;
        }
        String str;
        if (num < 0) {
            str = Integer.toString(num * -1);
        } else {
            str = Integer.toString(num);
        }
        while (str.length() > 1) {
            if (isPalindrome(str)) {
                return true;
            }
            str = descendant(str);
        }
        return false;
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static String descendant(String str) {
        StringBuilder builder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i += 2) {
            if (i == str.length() - 1) {
                builder.append(str.charAt(i));
            } else {
                int n = (int) str.charAt(i) + (int) str.charAt(i + 1) - 2 * ASCII_DIGITS_SHIFT;
                if (n >= TEN) {
                    builder.append('1');
                    builder.append((char) (n % TEN + ASCII_DIGITS_SHIFT));
                } else {
                    builder.append((char) (n + ASCII_DIGITS_SHIFT));
                }
            }
        }
        return builder.toString();
    }
}
