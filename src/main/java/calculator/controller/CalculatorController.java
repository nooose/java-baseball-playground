package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.StringCalculator;
import calculator.ui.InputView;
import calculator.ui.OutputView;

public class CalculatorController {
    public static void run() {
        Calculator calculator = new StringCalculator();
        calculator.input(InputView.inputFormula());
        OutputView.showResult(calculator);
    }
}
