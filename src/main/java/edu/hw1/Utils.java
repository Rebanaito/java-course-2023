package edu.hw1;

public final class Utils {
    private Utils() {
    }

    @SuppressWarnings("MagicNumber")
    private static void itoaInternal(StringBuilder builder, int num) {
        if (num > 9 || num < -9) {
            itoaInternal(builder, num / 10);
        } else if (num < 0) {
            builder.append('-');
        }
        int n = num % 10;
        if (n < 0) {
            n *= -1;
        }
        char c = (char) (n + 48);
        builder.append(c);
    }

    public static String itoa(int num) {
        StringBuilder builder = new StringBuilder();
        itoaInternal(builder, num);
        return builder.toString();
    }

    @SuppressWarnings("MagicNumber")
    private static int atoiInternal(char[] array) {
        int n = 0;
        boolean negative = (array[0] == '-');
        for (int i = 0; i < array.length; i++) {
            if (i == 0 && (array[i] == '-' || array[i] == '+')) {
                continue;
            }
            if (array[i] < '0' || array[i] > '9') {
                break;
            }
            if (negative) {
                n = n * 10 - (array[i] - '0');
            } else {
                n = n * 10 + (array[i] - '0');
            }
        }
        return n;
    }

    public static int atoi(String str) {
        if (str == null) {
            return 0;
        }
        if (str.isEmpty()) {
            return 0;
        }
        char[] array = str.toCharArray();
        return atoiInternal(array);
    }

    public static int atoi(char[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length == 0) {
            return 0;
        }
        return atoiInternal(array);
    }

    public static boolean isNum(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                if (!((str.charAt(i) == '-' || str.charAt(i) == '+') && i == 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
