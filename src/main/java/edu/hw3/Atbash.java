package edu.hw3;

public class Atbash {
    private Atbash() {
    }

    public static String atbash(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                builder.append((char) ('z' - (c - 'a')));
            } else if (c >= 'A' && c <= 'Z') {
                builder.append((char) ('Z' - (c - 'A')));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
