package edu.hw1;

@SuppressWarnings("TypeName")
public final class Task_7 {
    private Task_7() {
    }

    private static final int INT_MIN = -2147483648;

    @SuppressWarnings("MagicNumber")
    private static int[] itob(int num) {
        int[] bits = new int[32];
        int n = num;
        if (n < 0) {
            n *= -1;
        }
        int i = 31;
        for (; n != 0; i--) {
            bits[i] = n % 2;
            n /= 2;
        }
        int[] newBits = new int[31 - i++];
        System.arraycopy(bits, i, newBits, 0, newBits.length);
        return newBits;
    }

    private static int btoi(int[] bits) {
        int b = 1;
        int num = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] == 1) {
                num += b;
            }
            b *= 2;
        }
        return num;
    }

    public static int rotateLeft(int num, int shift) {
        if (shift < 0) {
            return (rotateRight(num, -shift));
        }
        if (num == INT_MIN) {
            return num;
        }
        int[] bits = itob(num);
        int sign = 1;
        if (num < 0) {
            sign = -1;
        }
        int[] spare = new int[bits.length];
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 0) {
                continue;
            }
            int index = i - shift;
            if (index < 0) {
                index = bits.length + index;
            }
            spare[index] = 1;
        }
        return (btoi(spare) * sign);
    }

    public static int rotateRight(int num, int shift) {
        if (shift < 0) {
            return (rotateLeft(num, -shift));
        }
        if (num == INT_MIN) {
            return num;
        }
        int[] bits = itob(num);
        int sign = 1;
        if (num < 0) {
            sign = -1;
        }
        int[] spare = new int[bits.length];
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 0) {
                continue;
            }
            int index = i + shift;
            if (index >= bits.length) {
                index %= bits.length;
            }
            spare[index] = 1;
        }
        return (btoi(spare) * sign);
    }
}
