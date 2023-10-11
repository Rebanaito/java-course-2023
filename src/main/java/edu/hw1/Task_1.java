package edu.hw1;

import java.util.logging.Logger;

@SuppressWarnings("TypeName")
public final class Task_1 {
    private Task_1() {
    }

    private final static Logger LOGGER = Logger.getLogger("LOGGER");

    private static boolean formatCheck(String[] halves) {
        if (halves.length != 2) {
            LOGGER.info("Invalid format, must be 'MM:SS'");
            return false;
        }
        if (!Utils.isNum(halves[0]) || !Utils.isNum(halves[1])) {
            LOGGER.info("Invalid format, must be digits only");
            return false;
        }
        if (halves[1].length() > 2) {
            LOGGER.info("Invalid format, seconds is a 2 digit number");
            return false;
        }
        return true;
    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String str) {
        String[] halves = str.split(":");
        if (!formatCheck(halves)) {
            return -1;
        }
        int minutes = Utils.atoi(halves[0]);
        int seconds = Utils.atoi(halves[1]);
        if (seconds > 59) {
            LOGGER.info("Invalid seconds value");
            return -1;
        }
        seconds += minutes * 60;
        return seconds;
    }
}
