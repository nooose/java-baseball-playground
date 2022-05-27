package study;

import calculator.Calculator;
import calculator.InputValue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void splitTest() {
        String str = "2 + 3 * 4 / 2";
        String[] expectedValue = {"2", "+", "3", "*", "4", "/", "2"};

        assertThat(str.split(" ")).containsExactly(expectedValue);
    }

    @Test
    void 타입확인_숫자() {
        InputValue value = new InputValue("2");

        assertThat(value.isNumber()).isTrue();
    }

    @Test
    void 타입확인_연산자() {
        InputValue value = new InputValue("+");

        assertThat(value.isOperator()).isTrue();
    }

    @Test
    void 연산자_확인() {
        InputValue value = new InputValue("1");

    }

    @Test
    void calculate() {
        Calculator calculator = new Calculator();

        calculator.input("2 + 3 * 4 / 2");
        assertThat(calculator.calculate()).isEqualTo(10);

        calculator.input("2 + 2 * 4 / 1");
        assertThat(calculator.calculate()).isEqualTo(16);
    }
}

