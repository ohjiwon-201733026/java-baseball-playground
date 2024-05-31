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

    public void addGameResult(GameTotalResult gameTotalResult) {
        this.strike += gameTotalResult.getStrike();
        this.ball += gameTotalResult.getBall();
    }

    public String getGameTotalResult() {

        if(this.ball == 0 && this.strike == 0) return "낫싱";

        String gameTotalResult = "";
        if(this.ball > 0) gameTotalResult = this.ball + "볼 ";
        if(this.strike > 0) gameTotalResult += this.strike + "스트라이크";

        return gameTotalResult;
    }

    public boolean isEnd() {
        return this.strike == 3;
    }
}
