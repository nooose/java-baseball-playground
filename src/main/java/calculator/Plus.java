package calculator;

public class Plus extends Operator {
    public Plus(String value) {
        super(value);
    }

    @Override
    int operate(int numberA, int numberB) {
        return numberA + numberB;
    }
}
