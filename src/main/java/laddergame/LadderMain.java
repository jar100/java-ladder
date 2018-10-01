package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.*;

public class LadderMain {
    public static void main(String[] args) {
        String person = InputView.getName();
        String result = InputView.getResult();
        int height = InputView.getLadder();

        LadderGame ladderGame = new LadderGame(person, height, result);
        ladderGame.makeLadder();
        ResultView.printResult(ladderGame);
//        ladderGame.moveUserPosition();

        // 이것도 메서드로
        String nameResult = "";
        while (!(nameResult.equals("all"))) {
            nameResult = InputView.getNameResult();
            ResultView.findResultAll(nameResult, ladderGame);
        }
    }
}
