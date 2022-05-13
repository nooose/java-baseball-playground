package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void charAt() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            str.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");

    }
}
