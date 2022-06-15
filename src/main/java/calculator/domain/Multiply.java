package calculator.domain;

public class Multiply extends Operator {

    public Multiply(String value) {
        super(value);
    }

    @Override
    int operate(int numberA, int numberB) {
        return numberA * numberB;
    }
}
