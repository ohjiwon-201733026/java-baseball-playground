package domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls(){
        this.balls = new ArrayList<>();
    }

    public void addBall(int ballNo) {
        if(balls.size() == 3)
            throw new IllegalArgumentException("ball은 3개까지 가능합니다");

        Ball ball = new Ball(getBallPosition(), ballNo);

        if(isUnique(ball)) balls.add(ball);
    }

    boolean isUnique(Ball ball) {
        return balls.stream().noneMatch(b -> b.getBallNo() == ball.getBallNo());
    }

    public int getBallCount() {
        return this.balls.size();
    }

    private int getBallPosition() {
        return this.getBallCount() + 1;
    }

    public GameTotalResult match(Ball ball) {
        GameTotalResult result = new GameTotalResult();

        for (Ball b : balls) {
            GameResult gameResult = b.match(ball);
            result.addGameResult(gameResult);
        }

        return result;
    }

    public GameTotalResult match(Balls balls) {
        GameTotalResult result = new GameTotalResult();

        for(Ball ball : this.balls) {
            GameTotalResult gameResultPerAnswer = balls.match(ball);
            result.addGameResult(gameResultPerAnswer);
        }

        return result;
    }
}
