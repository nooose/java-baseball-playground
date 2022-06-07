package study;

import calculator.InputValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValueTest {

    @ParameterizedTest
    @ValueSource(strings = {"2", "-10"})
    void 타입확인_숫자(String input) {
        assertThat(new InputValue(input).isNumber()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 타입확인_연산자(String input) {
        InputValue inputValue = new InputValue(input);

        assertThat(inputValue.isOperator()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"**", "#"})
    void 생성자_예외처리(String input) {
        assertThatThrownBy(() -> new InputValue(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equalsTest() {
        InputValue inputValue = new InputValue("5");

        assertThat(inputValue).isEqualTo(new InputValue("5"));
    }

}
