package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final int DEFAULT_OPERANDS = 0;
    private static final String DEFAULT_OPERATOR = "+";

    private String operatorHolder;
    private int operandsHolder;
    private final List<InputValue> values = new ArrayList<>();

    public Calculator() {
        init();
    }

    private void init() {
        values.clear();
        operandsHolder = DEFAULT_OPERANDS;
        operatorHolder = DEFAULT_OPERATOR;
    }

    public void input(String input) {
        init();

        String[] values = input.split(" ");
        for (String value : values) {
            this.values.add(new InputValue(value));
        }
    }

    public int calculate() {
        for (InputValue value : values) {
            operate(value);
        }

        return operandsHolder;
    }

    private void operate(InputValue value) {
        if (value.isNumber()) {
            operate(Integer.parseInt(value.getValue()));
        }

        if (value.isOperator()) {
            operatorHolder = value.getValue();
        }
    }

    private void operate(int number) {
        if (operatorHolder.equals("+")) {
            operandsHolder = plus(operandsHolder, number);
            return;
        }

        if (operatorHolder.equals("-")) {
            operandsHolder = minus(operandsHolder, number);
            return;
        }

        if (operatorHolder.equals("*")) {
            operandsHolder = multiply(operandsHolder, number);
            return;
        }

        if (operatorHolder.equals("/")) {
            operandsHolder = divide(operandsHolder, number);
        }
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        try {
            return a / b;
        } catch (Exception exception) {
            System.out.println("0으로 나눌 수 없습니다.");
            return a / b;
        }
    }
}
