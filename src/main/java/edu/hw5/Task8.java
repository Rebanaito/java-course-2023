package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    private Task8() {
    }

    public static boolean oddLength(String string) {
        Pattern pattern = Pattern.compile("^[01]([01][01])*$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean oddOrEven(String string) {
        Pattern pattern = Pattern.compile("^0([01][01])*$|^1[01]([01][01])*$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean zeroesThree(String string) {
        Pattern pattern = Pattern.compile("^(1*01*01*01*)*$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean notTwoOrThreeOnes(String string) {
        Pattern pattern = Pattern.compile("^(?!(11|111)$)[01]*");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean oddOnes(String string) {
        Pattern pattern = Pattern.compile("^(?!$)(1[01])*1?");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean mostlyZeroes(String string) {
        Pattern pattern = Pattern.compile("^0{2,}1?0*$|^0*1?0{2,}$|^0+1?0+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean onesNoRepeat(String string) {
        Pattern pattern = Pattern.compile("^(10)*1?$|^(01)*0?$|^0*$|^1$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
