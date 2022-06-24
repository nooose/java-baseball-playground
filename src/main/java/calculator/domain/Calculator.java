package calculator.domain;

import java.util.List;

public interface Calculator {

    void input(List<InputValue> values);
    int calculate();

}
