package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RefereeTest {

    @Test
    void 낫싱() {
        Referee referee = new Referee();
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls computerBalls = new Balls(Arrays.asList(4, 5, 6));

        PlayResult result = referee.compare(userBalls, computerBalls);
        Assertions.assertThat(result.toString()).isEqualTo("낫싱");
    }


    @Test
    void _3_스트라이크() {
        Referee referee = new Referee();
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));

        PlayResult result = referee.compare(userBalls, computerBalls);
        Assertions.assertThat(result.toString()).isEqualTo("3스트라이크");
    }

    @Test
    void _2볼() {
        Referee referee = new Referee();
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls computerBalls = new Balls(Arrays.asList(3, 1, 4));

        PlayResult result = referee.compare(userBalls, computerBalls);
        System.out.println("result.getStrike() = " + result.getStrike());
        System.out.println("result.getBall() = " + result.getBall());
        Assertions.assertThat(result.toString()).isEqualTo("2볼");
    }

    @Test
    void _2볼_1스트라이크() {
        Referee referee = new Referee();
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls computerBalls = new Balls(Arrays.asList(3, 2, 1));

        PlayResult result = referee.compare(userBalls, computerBalls);
        Assertions.assertThat(result.toString()).isEqualTo("2볼 1스트라이크");
    }
}
