package view;

import domain.GAME_PROGRESS;

import java.util.Scanner;

public class GameProgressInputView {

    public static GAME_PROGRESS getInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);

        int inputCode = scanner.nextInt();
        return GAME_PROGRESS.get(inputCode);
    }
}
