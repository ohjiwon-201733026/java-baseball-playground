package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallsTest {

    @Test
    @DisplayName("서로 다른 숫자 볼")
    public void uniqueBall() {
        Ball secondBall = new Ball(2, 2);

        Balls balls = new Balls();
        balls.addBall(1);

        assertThat(balls.isUnique(secondBall)).isTrue();
    }

    @Test
    @DisplayName("서로 다른 숫자 볼 테스트 - 같은 번호 존재")
    public void uniqueBall_notUnique() {
        Balls balls = new Balls();
        Ball secondBall = new Ball(2, 1);
        balls.addBall(1);

        assertThat(balls.isUnique(secondBall)).isFalse();
    }


    @Test
    @DisplayName("볼 세트에 중복된 볼 추가 ")
    public void addBall_notUnique() {
        Balls balls = new Balls();

        balls.addBall(1);
        balls.addBall(1);

        assertThat(balls.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 세트에 서로다른 볼 추가 ")
    public void addBall_unique() {
        Balls balls = new Balls();

        balls.addBall(1);
        balls.addBall(2);

        assertThat(balls.getBallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("3개 초과 볼 추가")
    public void addBall_overThree() {
        Balls balls = new Balls();

        balls.addBall(1);
        balls.addBall(2);
        balls.addBall(3);
        assertThrows(IllegalArgumentException.class, () -> balls.addBall(4));

    }

    @Test
    @DisplayName("balls match test")
    public void match_one_strike_one_ball() {
        Balls answer = new Balls();
        answer.addBall(1);
        answer.addBall(2);
        answer.addBall(3);

        Ball ball = new Ball(1,2);
        GameTotalResult result = answer.match(ball);

        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(0);
    }

    @Test
    @DisplayName("balls match test_strike")
    public void match_one_strike_one_strike() {
        Balls answer = new Balls();
        answer.addBall(1);
        answer.addBall(2);
        answer.addBall(3);

        Ball ball = new Ball(2,2);
        GameTotalResult result = answer.match(ball);

        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("balls match test_strike")
    public void match_one_strike_nothing() {
        Balls answer = new Balls();
        answer.addBall(1);
        answer.addBall(2);
        answer.addBall(3);

        Ball ball = new Ball(1,4);
        GameTotalResult result = answer.match(ball);

        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(0);
    }

    @Test
    @DisplayName("balls-balls match")
    public void match_balls_balls_nothing() {
        Balls answer = new Balls();
        answer.addBall(1);
        answer.addBall(2);
        answer.addBall(3);

        Balls input = new Balls();
        input.addBall(4);
        input.addBall(5);
        input.addBall(6);

        GameTotalResult result = answer.match(input);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(0);

    }

    @Test
    @DisplayName("balls-balls match")
    public void match_balls_balls_one_strike() {
        Balls answer = new Balls();
        answer.addBall(1);
        answer.addBall(2);
        answer.addBall(3);

        Balls input = new Balls();
        input.addBall(4);
        input.addBall(2);
        input.addBall(6);

        GameTotalResult result = answer.match(input);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(1);

    }

    @Test
    @DisplayName("balls-balls match")
    public void match_balls_balls_one_ball() {
        Balls answer = new Balls();
        answer.addBall(1);
        answer.addBall(2);
        answer.addBall(3);

        Balls input = new Balls();
        input.addBall(4);
        input.addBall(5);
        input.addBall(1);

        GameTotalResult result = answer.match(input);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(0);

    }

    @Test
    @DisplayName("balls-balls match")
    public void match_balls_balls_one_strike_one_ball() {
        Balls answer = new Balls();
        answer.addBall(1);
        answer.addBall(2);
        answer.addBall(3);

        Balls input = new Balls();
        input.addBall(4);
        input.addBall(2);
        input.addBall(1);

        GameTotalResult result = answer.match(input);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);

    }

    @Test
    @DisplayName("balls-balls match")
    public void match_balls_balls_three_strike() {
        Balls answer = new Balls();
        answer.addBall(1);
        answer.addBall(2);
        answer.addBall(3);

        Balls input = new Balls();
        input.addBall(1);
        input.addBall(2);
        input.addBall(3);

        GameTotalResult result = answer.match(input);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("String -> Balls convert")
    public void convertToBalls() {
        String strBalls = "123";

        Balls balls = Balls.convertToBalls(strBalls);

        assertThat(balls.getPositionedBall(0).getBallNo()).isEqualTo(1);
        assertThat(balls.getPositionedBall(1).getBallNo()).isEqualTo(2);
        assertThat(balls.getPositionedBall(2).getBallNo()).isEqualTo(3);
    }



}
