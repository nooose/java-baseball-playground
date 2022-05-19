package baseball;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public PlayResult() {
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.strike += 1;
            return;
        }

        if (status.isBall()) {
            this.ball += 1;
        }
    }

    public boolean isGameEnd() {
        return this.strike == Balls.MAX_SIZE;
    }

    @Override
    public String toString() {
        if (this.ball == 0 && this.strike == 0) {
            return "낫싱";
        }

        if (this.ball == 0) {
            return String.format("%d%s", this.strike, "스트라이크");
        }

        if (this.strike == 0) {
            return String.format("%d%s", this.ball, "볼");
        }

        return String.format("%d%s %d%s", this.ball, "볼", this.strike, "스트라이크");
    }
}
