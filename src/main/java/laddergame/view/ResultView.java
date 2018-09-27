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
        /*displayMyResult2(ladderGame.getUsers(),ladderGame.getResults());*/

    }


    //all
    public static void displayMyResult2(LadderGame ladderGame) {
        for (int i = 0; i < ladderGame.getUsers().size(); i++) {
            System.out.println(ladderGame.getUsers().get(i).getName() + " 결과는 " +
                    ladderGame.getResults().get(ladderGame.getUsers().get(i).getPosition()).getResult());
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

    public static void findResultAll(String result2, LadderGame ladderGame) {
        System.out.println("값찾기 실행");
        if (result2.equals("all")) {
            System.out.println("all");
            displayMyResult2(ladderGame);
            return;
        }
        findResult2(result2, ladderGame);
    }

    // get 쓰지말고 수정 해보자.
    private static void findResult2(String result2, LadderGame ladderGame) {
        //여기부터 하면된다.
        for (int i = 0; i < ladderGame.getUsers().size(); i++) {
            if (result2.equals(ladderGame.getUsers().get(i).getName())) {
                System.out.println(ladderGame.getUsers().get(i).getName() + " : " +
                        ladderGame.getResults().get(ladderGame.getUsers().get(i).getPosition()).getResult());
            }
        }
    }

    private static void isResult2(String result2, String userName) {
        if (result2 == userName) {
            System.out.println();
        }

    }
}
