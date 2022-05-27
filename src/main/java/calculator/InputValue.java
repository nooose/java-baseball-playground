package calculator;

public class InputValue {
    private static final String[] AVAILABE_OPERATORS = {"+", "-", "*", "/"};

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

    public void isValidateOperator(String operator) {
        for (String availalbeOperator : AVAILABE_OPERATORS) {
            if (availalbeOperator.equals(operator)) {
                return;
            }
        }

        throw new IllegalArgumentException("\"" + operator + "\"" + "는 지원하지 않는 연산자입니다.");
    }



    public boolean isNumber() {
        return type == InputType.NUMBER;
    }

    public boolean isOperator() {
        return type == InputType.OPERATOR;
    }

}
