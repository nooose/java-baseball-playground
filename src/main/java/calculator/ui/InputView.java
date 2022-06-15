package calculator.ui;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_MESSAGE = "입력: ";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String inputFormula() {
        System.out.print(INPUT_MESSAGE);
        return SCANNER.nextLine();
    }
}
