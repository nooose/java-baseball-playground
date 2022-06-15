package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator implements Calculator {

    public static final String BLANK = " ";
    private static final int DEFAULT_OPERANDS = 0;
    private static final Operator DEFAULT_OPERATOR;

    private final List<InputValue> values = new ArrayList<>();
    private Operator operatorHolder;
    private int operandsHolder;

    static {
        DEFAULT_OPERATOR = new Plus("+");
    }

    public StringCalculator() {
        init();
    }

    private void init() {
        values.clear();
        operandsHolder = DEFAULT_OPERANDS;
        operatorHolder = DEFAULT_OPERATOR;
    }

    @Override
    public void input(String input) {
        init();

        String[] values = input.split(BLANK);
        for (String value : values) {
            this.values.add(InputValueFactory.create(value));
        }
    }
    @Override
    public int calculate() {
        if (values.isEmpty()) {
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
