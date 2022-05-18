package baseball;

import java.util.List;

public class Referee {
    public PlayResult compare(Balls userBalls, Balls computerBalls) {
        PlayResult result = new PlayResult();
        List<Ball> computerBallsList = computerBalls.getBalls();

        for (Ball computerBall : computerBallsList) {
            BallStatus status = userBalls.compare(computerBall);
            result.report(status);
        }

        return result;
    }
}
