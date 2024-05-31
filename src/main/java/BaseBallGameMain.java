import domain.GAME_PROGRESS;
import service.BaseBallGameService;
import view.GameProgressInputView;

import static domain.GAME_PROGRESS.RESTART;

public class BaseBallGameMain {

    public static void main(String[] args) {

        BaseBallGameService baseBallGameService = new BaseBallGameService();

        GAME_PROGRESS gameProgress = RESTART;

        while (gameProgress.isRestartGame()) {
            baseBallGameService.play();

            gameProgress = GameProgressInputView.getInput();
        }


    }
}
