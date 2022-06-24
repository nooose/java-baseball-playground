package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator implements Calculator {

    private static final int DEFAULT_OPERANDS = 0;
    private static final Operator DEFAULT_OPERATOR;

    private List<InputValue> values;
    private Operator operatorHolder;
    private int operandsHolder;

    static {
        DEFAULT_OPERATOR = new Plus("+");
    }

    public StringCalculator() {
        init();
    }

    private void init() {
        if (values != null) {
            values.clear();
        }

        operandsHolder = DEFAULT_OPERANDS;
        operatorHolder = DEFAULT_OPERATOR;
    }

    @Override
    public void input(List<InputValue> values) {
        init();

        this.values = values;
    }
    @Override
    public int calculate() {
        if (values == null || values.isEmpty()) {
            throw new IllegalStateException("입력값이 없습니다.");
        }

        for (InputValue value : values) {
            operate(value);
        }

        return operandsHolder;
    }

    private void operate(InputValue value) {
        try {
            operandsHolder = operatorHolder.operate(operandsHolder, Integer.parseInt(value.getValue()));
        } catch (IllegalStateException | NumberFormatException e) {
            operatorHolder = (Operator) value;
        }
    }
}
