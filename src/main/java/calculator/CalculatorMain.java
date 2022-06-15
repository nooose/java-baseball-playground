package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력: ");
        StringCalculator calculator = new StringCalculator();
        calculator.input(scanner.nextLine());

        System.out.println("결과: " + calculator.calculate());

    }
}
