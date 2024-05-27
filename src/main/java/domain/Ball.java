package domain;

public class Ball {

    private int pos;
    private int ballNo;

    public Ball(int pos, int ballNo) {

        if(ballNo < 1 || ballNo > 9) {
            throw new IllegalArgumentException("Ball number must be between 1 and 9");
        }

        if(pos < 1 || pos > 3) {
            throw new IllegalArgumentException("Ball position must be between 1 and 3");
        }

        this.pos = pos;
        this.ballNo = ballNo;
    }

    public int getBallNo() {
        return this.ballNo;
    }

    public int getPos() {
        return this.pos;
    }

    public GameResult match(Ball ball) {

        if(this.equals(ball)) {
            return GameResult.STRIKE;
        }

        if(this.ballNo == ball.getBallNo()) {
            return GameResult.BALL;
        }
        return GameResult.NOTHING;
    }

    public boolean equals(Ball ball) {
        return getPos() == ball.getPos() && getBallNo() == ball.getBallNo();
    }

}
