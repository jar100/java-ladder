package laddergame;

import laddergame.domain.*;
import laddergame.utils.StringUtil;
import laddergame.view.ResultView;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderGameTest {


    // line 에 사용할 메소드
    public int movePosition2(int user, ArrayList<Line> ladder) {
        int userPosition = user;
        for (Line line : ladder) {
            userPosition = line.isMovePosition(userPosition);
            // 포지션 값을 리턴값으로
        }
        return userPosition;
    }

    // 새로운 메소드 구현해서 삿용
    @Test
    public void lineTest1() {
        // 0,  1,  2,  3,  4
        //   1,  0,  1,  0
        ArrayList<Line> lines = new ArrayList<>();
        // l-l l-l l
        // l l l-l l
        // l l-l l-l
        // l l l-l l
        lines.add(new Line(new ArrayList<>(Arrays.asList(true, false, true, false))));
        lines.add(new Line(new ArrayList<>(Arrays.asList(false, false, true, false))));
        lines.add(new Line(new ArrayList<>(Arrays.asList(false, true, false, true))));
        lines.add(new Line(new ArrayList<>(Arrays.asList(false, false, true, false))));
        //System.out.println(movePosition2(3,lines));
       // System.out.println(lines.get(0).elsePosition(3));
        System.out.println(lines.get(0).isPositionLast(4));
        //System.out.println(lines.get(0).getLine().size());
        assertThat(movePosition2(0,lines)).isEqualTo(3);
        assertThat(movePosition2(1,lines)).isEqualTo(0);
        assertThat(movePosition2(2,lines)).isEqualTo(1);
        assertThat(movePosition2(3,lines)).isEqualTo(4);
        assertThat(movePosition2(3,lines)).isEqualTo(4);
    }

    @Test
    public void lineTest2() {
        // 0,  1,  2,  3,  4
        //   1,  0,  1,  0
        ArrayList<Boolean> a = new ArrayList<>(Arrays.asList(true, false, true, false));
        Line line = new Line(a);
        assertThat(line.elsePosition(1)).isEqualTo(0);
        assertThat(line.elsePosition(2)).isEqualTo(3);
        assertThat(line.elsePosition(3)).isEqualTo(2);
//
    }


    @Test
    public void UserToString() {
        User user = new User("pobi", 3);
        System.out.println(user);
        assertThat(user.toString()).isEqualTo("유저 이름: pobi 포지션: 3");
    }

    @Test
    public void lineTest() {
        Boolean[] a = {true, false, false, true};
        ArrayList<Boolean> line = new ArrayList(Arrays.asList(a));
        // ture,false,false,true
        //      l-----l     l     l-----l
        String isTrue = "     l-----l     l     l-----l";
        assertThat(StringUtil.toStringLadder(line).toString()).isEqualTo(isTrue);
    }

    // "aa" 를 입력하면 "aa   " 를 반환
    @Test
    public void isResultLengthFIve() {
        int isTrue = 5;
        StringBuffer result = StringUtil.displayPosition("aa");
        assertThat(result.length()).isEqualTo(isTrue);
    }

    @Test
    public void sccnerTest() {

        String a = "aa";
        assertThat(a).isEqualTo("aa");
    }

    @Test
    public void ladderMainTest() {
        String person = "qwe, asd, zxcs, we, qee";
        int height = 5;
        String result = "꽝,5000,꽝,240,꽝";
        LadderGame ladderGame = new LadderGame(person, height, result);
        ladderGame.makeLadder();
        //ladderGame.moveUserPosition();
        ResultView.printResult(ladderGame);

        ResultView.displayNameResult(ladderGame);
    }

    @Test
    public void separatorTest() {
        String person = "qwe, asd, zxcs,we,qee";
        String[] a = person.split(", |,");
        assertThat(a[1]).isEqualTo("asd");
        assertThat(a[3]).isEqualTo("we");
        assertThat(a[4]).isEqualTo("qee");
    }

    @Test
    public void userTest() {
        User user = new User("pobi", 1);
        assertThat(user.getName()).isEqualTo("pobi");
    }

    @Test
    public void isTrue() {
        for (int i = 0; i < 5; i++) {
            boolean random = Line.isTrue();
            System.out.println(random);
        }
    }

    @Test
    public void makeLine() {
        ArrayList<Boolean> line = Line.makeLine(5);
        for (int i = 0; i < line.size(); i++) {
            System.out.println(line.get(i));
        }
        assertThat(line.get(0)).isEqualTo(true);
    }

    @Test
    public void isLine() {
        String line = StringUtil.lineOrBlank(true);

        assertThat(line).isEqualTo("-----");
    }

    @Test
    public void isBlank() {
        String line = StringUtil.lineOrBlank(false);

        assertThat(line).isEqualTo("     ");
    }
}
