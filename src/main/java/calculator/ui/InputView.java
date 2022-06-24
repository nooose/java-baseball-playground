package calculator.ui;

import calculator.domain.InputValue;
import calculator.domain.InputValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_MESSAGE = "입력: ";
    public static final String BLANK = " ";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static List<InputValue> inputFormula() {
        System.out.print(INPUT_MESSAGE);
        return generateInputValues(SCANNER.nextLine());
    }

    public static List<InputValue> generateInputValues(String input) {
        String[] splitValues = input.split(BLANK);
        List<InputValue> values = new ArrayList<>();

        for (String value : splitValues) {
            values.add(InputValueFactory.create(value));
        }
        return values;
    }
}
