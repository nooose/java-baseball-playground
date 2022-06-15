package study;

import calculator.domain.InputValue;
import calculator.domain.InputValueFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValueTest {

    @ParameterizedTest
    @ValueSource(strings = {"2", "-10"})
    void 타입확인_숫자(String input) {
        assertThat(InputValueFactory.create(input).isNumber()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 타입확인_연산자(String input) {
        InputValue inputValue = InputValueFactory.create(input);

        assertThat(inputValue.isOperator()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"**", "#"})
    void 생성자_예외처리(String input) {
        assertThatThrownBy(() -> InputValueFactory.create(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equalsTest() {
        InputValue inputValue = InputValueFactory.create("5");

        assertThat(inputValue).isEqualTo(InputValueFactory.create("5"));
    }

}
