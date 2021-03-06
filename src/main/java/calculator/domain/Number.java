package calculator.domain;

public class Number extends InputValue {
    public Number(String value) {
        super(value);
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    int operate(int numberA, int numberB) {
        throw new IllegalStateException("연산자가 아닙니다.");
    }
}
