package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    void play_3스트라이크() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Referee referee = new Referee();

        PlayResult result = referee.compare(userBalls, computerBalls);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void play_볼() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls computerBalls = new Balls(Arrays.asList(5, 3, 2));
        Referee referee = new Referee();

        PlayResult result = referee.compare(userBalls, computerBalls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void play_낫싱() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls computerBalls = new Balls(Arrays.asList(4, 5, 6));
        Referee referee = new Referee();

        PlayResult result = referee.compare(userBalls, computerBalls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1스트라이크_1볼() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls computerBalls = new Balls(Arrays.asList(1, 3, 4));
        Referee referee = new Referee();

        PlayResult result = referee.compare(userBalls, computerBalls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }


    @Test
    void strike() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));

        BallStatus status = userBalls.compare(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));

        BallStatus status = userBalls.compare(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));

        BallStatus status = userBalls.compare(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
