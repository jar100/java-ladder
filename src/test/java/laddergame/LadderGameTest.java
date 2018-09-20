package laddergame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    public void userTest() {
        User user = new User("pobi", 1);
        assertThat(user.getName()).isEqualTo("pobi");
        assertThat(user.getYPosition()).isEqualTo(1);
    }

    /*   @Test
       public void posittionTest() {
           // x,y = 0,1;
           User user = new User("pobi",1);
           //user 포지션과 대응하는  ladder  값이 ture 그럼 포지션 값은 y좌표 1증가.
           user.isMovePosition(true);
           assertThat(user.getYPosition()).isEqualTo(1);
       }
   */
    @Test
    public void isTrue() {
        for (int i = 0; i < 5; i++) {
            boolean random = Ladder.isTrue();
            System.out.println(random);
        }
    }

    @Test
    public void makeLine() {
        ArrayList<Boolean> line = Ladder.getOneLine(5);
        for (int i = 0; i < line.size(); i++) {
            System.out.println(line.get(i));
        }
        assertThat(line.get(0)).isEqualTo(true);
    }

    @Test
    public void LineException() {
        ArrayList<Boolean> line = new ArrayList<>();

        assertThat(line.get(0)).isEqualTo(true);
    }

    @Test
    public void isLine() {
        String line = ResultView.lineOrBlank(true);

        assertThat(line).isEqualTo("-");
    }

    @Test
    public void isBlank() {
        String line = ResultView.lineOrBlank(false);

        assertThat(line).isEqualTo(" ");
    }

    @Test
    public void ladder() {
        ArrayList<Boolean> line = Ladder.getOneLine(5);
        ResultView.toStringLadder(line);
    }

    @Test
    public void getHeight() {
        Ladder.makeLadder(3, 4);
    }

    @Test
    public void display() {
        List<ArrayList> ladders = Ladder.makeLadder(3, 4);
        ResultView.displayLadder(ladders);

    }
}
