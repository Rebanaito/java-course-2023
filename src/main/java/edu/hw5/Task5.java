package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private Task5() {
    }

    public static boolean validPlate(String plate) {
        Pattern pattern = Pattern.compile("^[АВЕКМНОРСТУХ][0-9]{3}[АВЕКМНОРСТУХ]{2}[1-9]?[0-9]{1,2}$");
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }
}
