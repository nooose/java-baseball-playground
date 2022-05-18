import baseball.Balls;
import baseball.PlayResult;
import baseball.Referee;
import utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String resultMessage = "";
        RandomNumberGenerator generator = new RandomNumberGenerator();
        Balls computerBalls = new Balls(generator.createRandomNumbers());

        while (!resultMessage.equals("3스트라이크")) {
            Balls userBalls = new Balls(askNumbers());

            Referee referee = new Referee();

            PlayResult result = referee.compare(userBalls, computerBalls);
            resultMessage = result.toString();

            System.out.println(result);
        }
        printEndMessage();
    }

    public static List<Integer> askNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split("")) {
            numbers.add(Integer.valueOf(number));
        }

        return numbers;
    }












    private static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
