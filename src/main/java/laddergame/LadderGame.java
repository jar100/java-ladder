package laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGame {
    static final int RANDOM_MAX_NUM = 10;
    static final int IS_TRUE = 5;
    int person = 0;
    int heigth = 0;

    public LadderGame(int person, int heigth) {
        this.person = person;
        this.heigth = heigth;
    }

    public List<ArrayList> run() {
        return getHeight(this.person,this.heigth);
    }

    public static boolean isTrue() {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_MAX_NUM);
        return randomNum >= IS_TRUE;
    }

    // l- 를 동시에 출력하다가 마지막만 l 출력
    public static ArrayList<Boolean> getOneLine(int person) {
        ArrayList<Boolean> ladder = new ArrayList<>();
        for (int i = 0; i < person-1; i++) {
            ladder.add(isTrue());
        }
        return ladder;
    }
    // ArrayList 와 List 의 관계
    public static List<ArrayList> getHeight(int person, int height) {
        List<ArrayList> ladders = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladders.add(getOneLine(person));
        }
        return ladders;
    }

}
