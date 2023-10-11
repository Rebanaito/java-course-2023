package edu.hw1;

@SuppressWarnings("TypeName")
public final class Task_5 {

    private Task_5() {
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("MagicNumber")
    private static String descendant(String str) {
        StringBuilder builder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i += 2) {
            if (i == str.length() - 1) {
                builder.append(str.charAt(i));
            } else {
                int n = (int) str.charAt(i) + (int) str.charAt(i + 1) - 2 * 48;
                if (n >= 10) {
                    builder.append('1');
                    builder.append((char) (n % 10 + 48));
                } else {
                    builder.append((char) (n + 48));
                }
            }
        }
        return builder.toString();
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindromeDescendant(int num) {
        if ((num > 0 && num < 10) || (num < 0 && num > -10)) {
            return true;
        }
        if (num == -2147483648) {
            return false;
        }
        String str;
        if (num < 0) {
            str = Utils.itoa(num * -1);
        } else {
            str = Utils.itoa(num);
        }
        while (str.length() > 1) {
            if (isPalindrome(str)) {
                return true;
            }
            str = descendant(str);
        }
        return false;
    }
}
