package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public static final int MAX_SIZE = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        this.balls = mapBalls(numbers);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    private List<Ball> mapBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            balls.add(new Ball(i + 1, numbers.get(i)));
        }

        return balls;
    }

    public BallStatus compare(Ball computerBall) {
        return balls.stream()
                .map(ball -> ball.play(computerBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }


}
