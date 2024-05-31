package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTotalResultTest {


    @Test
    @DisplayName("스트라이크인 경우 결과 추가")
    public void addGameResult_strike() {
        GameResult strike = GameResult.STRIKE;

        GameTotalResult result = new GameTotalResult();
        result.addGameResult(strike);

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("ball인 경우 결과 추가")
    public void addGameResult_ball() {
        GameResult ball = GameResult.BALL;

        GameTotalResult result = new GameTotalResult();
        result.addGameResult(ball);

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("nothing인 경우 결과 추가")
    public void addGameResult_nothing() {
        GameResult nothing = GameResult.NOTHING;

        GameTotalResult result = new GameTotalResult();
        result.addGameResult(nothing);

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("게임결과 합산")
    public void addGameResult_gameTotalResult() {
        GameTotalResult totalResult = new GameTotalResult();
        totalResult.addGameResult(GameResult.STRIKE);
        totalResult.addGameResult(GameResult.STRIKE);

        GameTotalResult result = new GameTotalResult();
        result.addGameResult(GameResult.BALL);
        result.addGameResult(GameResult.STRIKE);

        totalResult.addGameResult(result);

        assertThat(totalResult.getStrike()).isEqualTo(3);
        assertThat(totalResult.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임결과 반환_nothing")
    public void getGameTotalResult_nothing() {
        GameTotalResult totalResult = new GameTotalResult();

        assertThat(totalResult.getGameTotalResult()).isEqualTo("낫싱");
    }


    @Test
    @DisplayName("게임결과 반환_ball")
    public void getGameTotalResult_ball() {
        GameTotalResult totalResult = new GameTotalResult();
        totalResult.addGameResult(GameResult.BALL);

        assertThat(totalResult.getGameTotalResult()).isEqualTo("1볼 ");
    }

    @Test
    @DisplayName("게임결과 반환_strike")
    public void getGameTotalResult_strike() {
        GameTotalResult totalResult = new GameTotalResult();
        totalResult.addGameResult(GameResult.STRIKE);

        assertThat(totalResult.getGameTotalResult()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("게임결과 반환_ball_and_strike")
    public void getGameTotalResult_ball_and_strike() {
        GameTotalResult totalResult = new GameTotalResult();
        totalResult.addGameResult(GameResult.BALL);
        totalResult.addGameResult(GameResult.STRIKE);

        assertThat(totalResult.getGameTotalResult()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("게임종료여부 확인_종료")
    public void isEnd_true() {
        GameTotalResult totalResult = new GameTotalResult();
        totalResult.addGameResult(GameResult.STRIKE);
        totalResult.addGameResult(GameResult.STRIKE);
        totalResult.addGameResult(GameResult.STRIKE);

        assertThat(totalResult.isEnd()).isTrue();
    }


    @Test
    @DisplayName("게임종료여부 확인_종료아님")
    public void isEnd_false() {
        GameTotalResult totalResult = new GameTotalResult();
        totalResult.addGameResult(GameResult.STRIKE);
        totalResult.addGameResult(GameResult.BALL);
        totalResult.addGameResult(GameResult.STRIKE);

        assertThat(totalResult.isEnd()).isFalse();
    }

}
