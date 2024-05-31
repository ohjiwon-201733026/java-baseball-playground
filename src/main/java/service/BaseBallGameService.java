package service;

import domain.Balls;
import domain.GameTotalResult;
import factory.AnswerFactory;
import view.AnswerInputView;

public class BaseBallGameService {

    public void play() {
        Balls answer = AnswerFactory.generate();
        GameTotalResult result = new GameTotalResult();

        while (!result.isEnd()) {
            Balls userAnswer = AnswerInputView.inputUserAnswer();

            result = answer.match(userAnswer);
            System.out.println(result.getGameTotalResult());
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }
}
