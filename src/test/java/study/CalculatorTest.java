package study;

import calculator.InputValueFactory;
import calculator.StringCalculator;
import calculator.InputValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new StringCalculator();
    }

    @Test
    void splitTest() {
        String str = "2 + 3 * 4 / 2";
        String[] expectedValue = {"2", "+", "3", "*", "4", "/", "2"};

        assertThat(str.split(" ")).containsExactly(expectedValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 + 2 * 4 / 1:16"}, delimiter = ':')
    void calculate(String input, String expected) {
        calculator.input(input);

        assertThat(calculator.calculate()).isEqualTo(Integer.parseInt(expected));
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }
}

