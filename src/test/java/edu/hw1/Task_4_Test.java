package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_4_Test {
    @Test
    @DisplayName("Normal strings")
    void normalStrings() {
        String nums = "123456";
        String result = Task_4.fixString(nums);
        assertThat(result).isEqualTo("214365").hasSameSizeAs(nums);

        String sentence = "hTsii  s aimex dpus rtni.g";
        result = Task_4.fixString(sentence);
        assertThat(result).isEqualTo("This is a mixed up string.").hasSameSizeAs(sentence);

        String chars = "badce";
        result = Task_4.fixString(chars);
        assertThat(result).isEqualTo("abcde").hasSameSizeAs(chars);

        String empty = "";
        result = Task_4.fixString(empty);
        assertThat(result).isEqualTo("").hasSameSizeAs(empty);
    }

    @Test
    @DisplayName("Null string")
    void nullString() {
        String result = Task_4.fixString(null);
        assertThat(result).isNull();
    }
}