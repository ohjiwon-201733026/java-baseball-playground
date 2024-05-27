package domain;

public class GameTotalResult {

    private int strike;
    private int ball;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void addGameResult(GameResult gameResult) {

        if(gameResult == GameResult.BALL) {
            ball++;
        }

        if(gameResult == GameResult.STRIKE) {
            strike++;
        }
    }
}
