package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @Test
    void 생성자_에러() {
        assertThatThrownBy(() -> {
            new Ball(1, Ball.MIN_NO - 1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Ball(1, Ball.MAX_NO + 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void strike() {
        Ball userBall = new Ball(1, 1);
        Ball computerBall = new Ball(1, 1);

        BallStatus status = userBall.play(computerBall);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }


    @Test
    void ball() {
        Ball userBall = new Ball(1, 1);
        Ball computerBall = new Ball(2, 1);

        BallStatus status = userBall.play(computerBall);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball userBall = new Ball(1, 1);
        Ball computerBall = new Ball(1, 5);

        BallStatus status = userBall.play(computerBall);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
