package calculator.ui;

import calculator.domain.Calculator;

public class OutputView {

    public static final String RESULT_MESSAGE = "결과: ";

    public static void showResult(Calculator calculator) {
        System.out.println(RESULT_MESSAGE + calculator.calculate());
    }
}
