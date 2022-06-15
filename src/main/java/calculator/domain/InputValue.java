package calculator.domain;

import java.util.Objects;

public abstract class InputValue {
    private final String value;

    public InputValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    abstract public boolean isNumber();

    abstract public boolean isOperator();

    abstract int operate(int numberA, int numberB);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputValue)) return false;
        InputValue that = (InputValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
