package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.*;

public class LadderMain {
    public static void main(String[] args) {
        String person = InputView.getName();
        String result = InputView.getResult();
        int height = InputView.getLadder();

        LadderGame ladderGame = new LadderGame(person, height , result);
        ladderGame.run();
        ResultView.printResult(ladderGame);
        ladderGame.run2();

        String result2 = InputView.getResult2();
        ResultView.findResultAll(result2, ladderGame);

       // ResultView.displayMyResult2(ladderGame);
    }
}
