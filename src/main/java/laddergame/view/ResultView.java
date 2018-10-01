package laddergame.view;

import laddergame.domain.*;
import laddergame.utils.StringUtil;

import java.util.ArrayList;

public class ResultView {
    private static final String BLANK = " ";

    public static void printResult(LadderGame ladderGame) {
        displayMembers(ladderGame.getUsers());
        displayLadder(ladderGame.getLadder());
        displayMyResult(ladderGame.getResults());

    }

    public static void displayNameResult(LadderGame ladderGame) {
        for (int i = 0; i < ladderGame.getUsers().size(); i++) {
            System.out.println(ladderGame.getUsers().get(i).getName() + " 결과는 " +
                    ladderGame.getResults().get(ladderGame.movePosition2(ladderGame.getUsers().get(i))).getResult());
        }
    }

    private static void displayMyResult(ArrayList<MyResult> results) {
        System.out.print(BLANK);
        System.out.print(BLANK);
        for (MyResult result : results) {
            System.out.print(BLANK);
            System.out.print(StringUtil.displayPosition(result.getResult()));
        }
        System.out.println();
    }

    public static void displayMembers(ArrayList<User> members) {
        System.out.print(BLANK);
        System.out.print(BLANK);
        for (User member : members) {
            System.out.print(BLANK);
            System.out.print(StringUtil.displayPosition(member.getName()));
        }
        System.out.println();
    }

    public static void displayLadder(ArrayList<Line> ladders) {
        for (Line ladder : ladders) {
            System.out.println(StringUtil.toStringLadder(ladder.getLine()));
        }
    }

    public static void findResultAll(String result, LadderGame ladderGame) {
        System.out.println("실행 값");
        if (result.equals("all")) {
            displayNameResult(ladderGame);
            return;
        }
        findResult(result, ladderGame);
    }

    // 원하는 결과만 출력
    private static void findResult(String result, LadderGame ladderGame) {
        for (int i = 0; i < ladderGame.getUsers().size(); i++) {
            isShowResult(result, ladderGame, i);
        }
    }

    // toString 으로
    private static void isShowResult(String result, LadderGame ladderGame, int i) {
        if (result.equals(ladderGame.getUsers().get(i).getName())) {
            System.out.println(ladderGame.getUsers().get(i).getName() + " : " +
                    ladderGame.getResults().get(ladderGame.getUsers().get(i).getPosition()).getResult());
        }
    }

}
