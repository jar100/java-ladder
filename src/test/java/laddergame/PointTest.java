package laddergame;

import laddergame.domain.LadderGame;
import laddergame.domain.Line;
import laddergame.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void userMove() {
        LadderGame ladderGame = new LadderGame();
        String[] members = {"pobi", "peter", "nana", "toto", "moka"};
        ArrayList<User> users = ladderGame.makeUsers(members);
        assertThat(users.get(0).getPosition()).isEqualTo(0);
        users.get(0).moveRight(true);
        users.get(0).moveRight(false);
        // user position 0 에서 1로 증가;
        assertThat(users.get(0).getPosition()).isEqualTo(1);
        users.get(0).moveLeft(true);
        // user posittion 1 에서 0으로 감소
        assertThat(users.get(0).getPosition()).isEqualTo(0);
    }

    @Test
    public void userMove2() {
        LadderGame ladderGame = new LadderGame();
        String[] members = {"pobi", "peter", "nana", "toto", "moka"};
        String[] myResult = {"5000", "꽝", "꽝", "300", "꽝"};
        ArrayList<User> users = ladderGame.makeUsers(members);
        ArrayList<Boolean> line2 = new ArrayList<Boolean>(Arrays.asList(true, false, true, false));
        movePosition2(users, line2);
        //users.get(0).getPosition() 0 이면 오른쪽 동작
        //users.get(0).getPosition() users.size() 면 왼쪽 동작
        // 나머지는 좌측 우측 판별후 true 면 동작.
        for (int i = 0; i < 4; i++) {
            System.out.println(users.get(i).getName() + " 결과는 " + myResult[(users.get(i).getPosition())]);
        }
        assertThat(users.get(users.size() - 1).getPosition()).isEqualTo(4);


    }

    @Test
    public void userMove3() {
        LadderGame ladderGame = new LadderGame();
        String[] members = {"pobi", "peter"};
        ArrayList<User> users = ladderGame.makeUsers(members);
        ArrayList<Boolean> line2 = new ArrayList<Boolean>(Arrays.asList(true));

        movePosition2(users, line2);

        assertThat(users.get(0).getPosition()).isEqualTo(1);
        assertThat(users.get(1).getPosition()).isEqualTo(0);
    }

    // 유저에 넣어야 하나? 게임에 넣어야 하나?
    private void movePosition2(ArrayList<User> users, ArrayList<Boolean> line2) {
        boolean isRight = false;
        boolean isLeft = false;
        users.get(0).moveRight(line2.get(0));
        users.get(users.size() - 1).moveLeft(line2.get(line2.size() - 1));
        for (int i = 1; i < users.size() - 1; i++) {
            // i 자리의 ladder 값에 대해 i-1 i+1 의 line 값을 판별 하고
            //isRight 와 isLeft 의 값을 line이랑 비교해서 true false 구해서 두개 실행
            isLeft = line2.get(i - 1);
            //System.out.println(i - 1 +" 이것의 왼쪽 " + line2.get(i - 1));
            isRight = line2.get(i);
            //System.out.println(i  +" 이것의 오른쪽 " + line2.get(i));
            users.get(i).moveLeft(isLeft);
            users.get(i).moveRight(isRight);
        }
    }

    @Test
    public void userTest() {
        LadderGame ladderGame = new LadderGame();
        String[] members = {"pobi", "peter", "nana", "toto", "moka"};
        ArrayList<User> users = ladderGame.makeUsers(members);
        assertThat(users.get(0).getPosition()).isEqualTo(0);
        assertThat(users.get(1).getPosition()).isEqualTo(1);
        assertThat(users.get(2).getPosition()).isEqualTo(2);
    }

    @Test
    public void ladderTest() {
        ArrayList<Boolean> line = new ArrayList<Boolean>(Arrays.asList(true, false, false, false));
        Line line1 = new Line(line);
        assertThat(line1.isMove(0)).isTrue();
        assertThat(line1.isMove(1)).isFalse();
    }


}
