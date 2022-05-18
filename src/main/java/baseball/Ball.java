package baseball;

public class Ball {
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        if (!valid(number)) {
            throw new IllegalArgumentException("범위 에러");
        }

        this.position = position;
        this.number = number;
    }

    public boolean valid(int no) {
        return no >= MIN_NO && no <= MAX_NO;
    }
    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (isEqualBallNumber(ball)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isEqualBallNumber(Ball ball) {
        return this.number == ball.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;

        Ball ball = (Ball) o;

        if (position != ball.position) return false;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + number;
        return result;
    }
}
