package calculator;

public class Minus extends Operator {
    public Minus(String value) {
        super(value);
    }

    @Override
    int operate(int numberA, int numberB) {
        return numberA - numberB;
    }
}
