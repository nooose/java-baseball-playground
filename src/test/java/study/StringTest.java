package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] splitStringArray = "1,2".split(",");

        assertThat(splitStringArray).contains("1", "2");
        assertThat(splitStringArray).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String subStr = str.substring(1, 4);

        assertThat(subStr).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> str.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(4)).withMessageMatching("String index out of range: \\d+");

    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 + 1 * 2 / 2:2"}, delimiter = ':')
    void calculateString(String input, String expected) {
        String[] splitStr = getSplitStr(input);
        int expectedNumber = Integer.parseInt(expected);

        int result = calculate(splitStr);

        assertThat(result).isEqualTo(expectedNumber);
    }

    int calculate(String[] splitStr) {
        for (int i = 1; i < splitStr.length; i += 2) {
            String op = splitStr[i];

            int a = Integer.parseInt(splitStr[i - 1]);
            int b = Integer.parseInt(splitStr[i + 1]);

            switch (op) {
                case "+":
                    splitStr[i + 1] = Integer.toString(plus(a, b));
                    break;
                case "-":
                    splitStr[i + 1] = Integer.toString(minus(a, b));
                    break;
                case "*":
                    splitStr[i + 1] = Integer.toString(multiply(a, b));
                    break;
                case "/":
                    splitStr[i + 1] = Integer.toString(divide(a, b));
                    break;
            }
        }

        return Integer.parseInt(splitStr[splitStr.length - 1]);
    }

    String[] getSplitStr(String value) {
        return value.split(" ");
    }

    int plus(int a, int b) {
        return a + b;
    }

    int minus(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        try {
            return a / b;
        } catch (Exception exception) {
            System.out.println("0?????? ?????? ??? ????????????.");
            return a / b;
        }
    }
}
