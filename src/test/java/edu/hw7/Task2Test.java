package edu.hw7;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Task2Test {
    @Test
    @DisplayName("Valid values tests")
    void validValuesTest() {
        BigInteger factorial = ThreadedFactorial.getFactorial(1);
        assertThat(factorial.intValue()).isEqualTo(1);

        factorial = ThreadedFactorial.getFactorial(0);
        assertThat(factorial.intValue()).isEqualTo(1);

        factorial = ThreadedFactorial.getFactorial(10);
        assertThat(factorial.equals(BigInteger.valueOf(3628800))).isTrue();

        factorial = ThreadedFactorial.getFactorial(20);
        assertThat(factorial
                .equals
                        (new BigInteger("2432902008176640000")))
                .isTrue();

        factorial = ThreadedFactorial.getFactorial(50);
        assertThat(factorial
                .equals
                        (new BigInteger("30414093201713378043612608166064768844377641568960512000000000000")))
                .isTrue();
    }

    @Test
    @DisplayName("Invalid values test")
    void invalidValuesTest() {
        boolean exception = false;

        try {
            ThreadedFactorial.getFactorial(-1);
        } catch (IllegalArgumentException ignored) {
            exception = true;
        } finally {
            assertThat(exception).isTrue();
        }
    }
}
