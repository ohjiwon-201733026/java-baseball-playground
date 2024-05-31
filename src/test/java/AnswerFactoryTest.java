import domain.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnswerFactoryTest {

    @Test
    @DisplayName("3자리 랜덤 숫자 생성")
    public void generate_three() {
        Balls answer = AnswerFactory.generate();

        assertThat(answer.getBallCount()).isEqualTo(3);
    }

}
