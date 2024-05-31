package factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomBallFactoryTest {

    @Test
    @DisplayName("1~9사이 자연수 랜덤번호 생성")
    public void generate_between_one_to_nine() {
        int randomNumber = RandomBallFactory.generate();

        assertThat(randomNumber).isBetween(1 , 9);
    }
}
