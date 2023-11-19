package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    private Task7() {
    }

    public static boolean threePlus(String string) {
        Pattern pattern = Pattern.compile("^[01]{2}0[01]*$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean sameFirstLast(String string) {
        Pattern pattern = Pattern.compile("^([0|1])([0|1]+)\\1$|^[0|1]$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean oneToThree(String string) {
        Pattern pattern = Pattern.compile("^[01]{1,3}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
