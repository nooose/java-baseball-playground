package calculator;

public abstract class Operator extends InputValue {

    public Operator(String value) {
        super(value);
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isOperator() {
        return true;
    }

}
