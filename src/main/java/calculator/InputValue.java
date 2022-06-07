package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class InputValue {
    private static final String[] OPERATORS = {"+", "-", "*", "/"};

    private InputType type;
    private final String value;

    public InputValue(String value) {
        setType(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void setType(String value) {
        try {
            Integer.parseInt(value);
            type = InputType.NUMBER;
        } catch (NumberFormatException e) {
            isValidateOperator(value);
            type = InputType.OPERATOR;
        }
    }

    private void isValidateOperator(String operator) {
        Optional<String> availableOperator = Arrays.stream(OPERATORS)
                .filter(op -> op.equals(operator))
                .findAny();

        availableOperator.orElseThrow(() -> new IllegalArgumentException("\"" + operator + "\"" + "는 지원하지 않는 연산자입니다."));
    }

    public boolean isNumber() {
        return type == InputType.NUMBER;
    }

    public boolean isOperator() {
        return type == InputType.OPERATOR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputValue)) return false;
        InputValue that = (InputValue) o;
        return type == that.type && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}
