import domain.Balls;
import factory.RandomBallFactory;

public class AnswerFactory {

    public static Balls generate() {

        Balls answer = new Balls();

        while (!answer.isEndGenerateBalls()) {
            int ballNo = RandomBallFactory.generate();

            answer.addBall(ballNo);
        }

        return answer;
    }
}
