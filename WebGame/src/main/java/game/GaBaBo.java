package game;

import java.util.Random;

public class GaBaBo {

    public String play(String userChoice) {
        String[] gbb = {"가위", "바위", "보"};
        Random rd = new Random();
        String comChoice = gbb[rd.nextInt(3)];

        int userIdx = switch(userChoice) {
            case "가위" -> 0;
            case "바위" -> 1;
            case "보" -> 2;
            default -> -1;
        };

        if (userIdx == -1) return "잘못된 입력입니다.";

        int comIdx = switch(comChoice) {
            case "가위" -> 0;
            case "바위" -> 1;
            default -> 2;
        };

        int result = userIdx - comIdx;
        String outcome;
        if (result == 0) outcome = "무승부입니다";
        else if (result == -1 || result == 2) outcome = "컴퓨터 승!";
        else outcome = "사용자 승!";

        return "사용자: " + userChoice + ", 컴퓨터: " + comChoice + " → " + outcome;
    }
}
