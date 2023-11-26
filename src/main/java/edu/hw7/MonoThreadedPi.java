package edu.hw7;

public class MonoThreadedPi {
    private MonoThreadedPi() {}

    @SuppressWarnings("MagicNumber")
    public static double getPi(int n) {
        if (n < 1) {
            return -1;
        }

        double x;
        double y;
        double distance;
        double pi = 0;

        int circleCount = 0;
        int totalCount = 0;

        for (int i = 0; i < n; i++) {

            x = Math.random() * 2 - 1;
            y = Math.random() * 2 - 1;

            distance = x * x + y * y;

            if (distance <= 1) {
                circleCount++;
            }
            totalCount++;

            pi = ((4.0 * circleCount) / totalCount);
        }
        return pi;
    }
}
