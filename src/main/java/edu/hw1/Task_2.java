package edu.hw1;

@SuppressWarnings("TypeName")
public final class Task_2 {
    private Task_2() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int num) {
        int count = 1;
        int n = num;
        if (n < 0) {
            while (n <= -10) {
                count++;
                n /= 10;
            }
        } else {
            while (n >= 10) {
                count++;
                n /= 10;
            }
        }
        return count;
    }
}
