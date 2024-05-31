package view;

import domain.Balls;

import java.util.Scanner;

public class AnswerInputView {

    public static Balls inputUserAnswer() {
        System.out.print("숫자를 입력해 주세요 :");

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        return Balls.convertToBalls(userInput);
    }
}
