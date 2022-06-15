package calculator.domain;

public class Divide extends Operator {
    public Divide(String value) {
        super(value);
    }

    @Override
    int operate(int numberA, int numberB) {
        if (numberB == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return numberA / numberB;
    }
}
