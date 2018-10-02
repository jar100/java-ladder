package laddergame.view;

import laddergame.domain.*;
import laddergame.utils.MyStringUtil;

import java.util.ArrayList;

public class ResultView {
    private static final String BLANK = " ";
    private LadderGame ladderGame;

    public ResultView(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public void printResult() {
        displayMembers(this.ladderGame.getUsers());
        displayLadder(this.ladderGame.getLadder());
        displayMyResult(this.ladderGame.getResults());
    }

    private void displayMyResult(ArrayList<MyResult> results) {
        System.out.print(BLANK+BLANK);
        for (MyResult result : results) {
            System.out.print(BLANK + MyStringUtil.displayPosition(result.getResult()));
        }
        System.out.println();
    }

    private void displayMembers(ArrayList<User> members) {
        System.out.print(BLANK + BLANK);
        for (User member : members) {
            System.out.print(BLANK + MyStringUtil.displayPosition(member.getName()));
        }
        System.out.println();
    }

    private void displayLadder(ArrayList<Line> ladders) {
        for (Line ladder : ladders) {
            System.out.println(MyStringUtil.toStringLadder(ladder.getLine()));
        }
    }

    public void RunNameResult() {
        String nameResult = "";
        while (!(nameResult.equals("all"))) {
            nameResult = InputView.getNameResult();
            findResultAll(nameResult);
        }
    }

    // all 찾는중
    public void findResultAll(String result) {
        System.out.println("실행 값");
        if (result.equals("all")) {
            displayNameResult();
            return;
        }
        findNameResult(result);
    }

    public void displayNameResult() {
        for (int i = 0; i < this.ladderGame.getUsers().size(); i++) {
            MyStringUtil.nameResultToString(this.ladderGame, i);
        }
    }

    // 원하는 결과만 출력
    public void findNameResult(String result) {
        for (int i = 0; i < this.ladderGame.getUsers().size(); i++) {
            isNameResult(result, i);
        }
    }
    public void isNameResult(String result, int i) {
        if (result.equals(this.ladderGame.getUsers().get(i).getName())) {
            MyStringUtil.nameResultToString(this.ladderGame, i);
        }
    }

}
