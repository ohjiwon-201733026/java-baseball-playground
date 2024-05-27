package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallTest {

    @Test
    @DisplayName("1~9 사이 볼 체크")
    public void ball_one_to_nine() {
        Ball ball = new Ball(1,1);
        assertThat(ball.getBallNo()).isBetween(1,9);
    }

    @Test
    @DisplayName("1~9사이가 아닌 볼")
    public void ball_not_one_to_nine(){
        assertThrows(IllegalArgumentException.class, () -> new Ball(1,10));
    }

    @Test
    @DisplayName("ball result 확인 - nothing 확인")
    public void match_ball_nothing() {
        Ball answer = new Ball(1,1);
        Ball input = new Ball(2,2);

        assertThat(answer.match(input)).isEqualTo( GameResult.NOTHING);
    }

    @Test
    @DisplayName("ball result 확인 - ball 확인")
    public void match_ball_ball() {
        Ball answer = new Ball(1,1);
        Ball input = new Ball(2,1);

        assertThat(answer.match(input)).isEqualTo( GameResult.BALL);
    }


    @Test
    @DisplayName("ball result 확인 - strike 확인")
    public void match_ball_strike() {
        Ball answer = new Ball(1,2);
        Ball input = new Ball(1,2);

        assertThat(answer.match(input)).isEqualTo( GameResult.STRIKE);
    }



}
