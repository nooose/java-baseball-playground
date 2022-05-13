package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");

        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] splitStringArray = "1,2".split(",");

        assertThat(splitStringArray).contains("1", "2");
        assertThat(splitStringArray).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String subStr = str.substring(1, str.length() - 1);

        assertThat(subStr).isEqualTo("1,2");
    }
}
