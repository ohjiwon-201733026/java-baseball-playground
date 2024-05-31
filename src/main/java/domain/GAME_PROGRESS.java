package domain;

import java.util.Arrays;

public enum GAME_PROGRESS {

    RESTART(1)
    , END(2)
    ;

    int inputCode;

    GAME_PROGRESS(int inputCode) {
        this.inputCode = inputCode;
    }

    public boolean isRestartGame() {
        return this == RESTART;
    }

    public static GAME_PROGRESS get(int inputCode) {
        return Arrays.stream(GAME_PROGRESS.values()).filter( gprg -> gprg.inputCode == inputCode).findFirst().orElse(null);

    }
}
