package gamelogic;

import java.util.Random;

public class Guess {
    private int number;

    public Guess() {
        number = new Random().nextInt(10) + 1; // 1~10
    }

    public String check(int userInput) {
        if (userInput == number) return "정답!";
        else if (userInput < number) return userInput + " - 더 큰 숫자입니다.";
        else return userInput + " - 더 작은 숫자입니다.";
    }

    public int getNumber() {
        return number;
    }
}
