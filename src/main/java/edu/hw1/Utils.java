package edu.hw1;

public final class Utils {
    private Utils() {
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
