package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class InputValueFactory {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIFLY = "*";
    private static final String DIVIDE = "/";

    private static final Map<String, Function<String, Operator>> classifier = new HashMap<>();

    static {
        classifier.put(PLUS, Plus::new);
        classifier.put(MINUS, Minus::new);
        classifier.put(MULTIFLY, Multiply::new);
        classifier.put(DIVIDE, Divide::new);
    }

    public static InputValue create(String value) {
        try {
            Integer.parseInt(value);
            return new Number(value);
        } catch (NumberFormatException e) {
            return classifyOperator(value);
        }
    }

    private static Operator classifyOperator(String value) {
        if (!classifier.containsKey(value)) {
            throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }

        return classifier.get(value).apply(value);
    }
}
