package edu.hw1;

@SuppressWarnings("TypeName")
public final class Task_4 {
    private Task_4() {
    }

    public static String fixString(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i += 2) {
            if (i != str.length() - 1) {
                builder.append(str.charAt(i + 1));
            }
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
