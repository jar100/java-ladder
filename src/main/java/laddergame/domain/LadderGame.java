package laddergame.domain;

import java.util.ArrayList;

public class LadderGame {
    static final String SEPARATOR = ", |,";
    private int height = 0;
    private ArrayList<Line> ladder = new ArrayList<>();
    private ArrayList<User> users;
    private ArrayList<MyResult> results;

    public LadderGame() {

    }

    public LadderGame(String members, int height, String results) {
        this.users = makeUsers(members.split(SEPARATOR));
        this.height = height;
        this.results = makeResults(results.split(SEPARATOR));
    }

    private ArrayList<MyResult> makeResults(String[] results) {
        ArrayList<MyResult> myResults = new ArrayList<>();
        for (String result : results) {
            myResults.add(new MyResult(result));
        }
        return myResults;
    }

    public ArrayList<User> makeUsers(String[] names) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            users.add(new User(names[i], i));
        }
        return users;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void makeLadder() {
        for (int i = 0; i < this.height; i++) {
            ladder.add(new Line(this.users.size()));
        }
    }

    // 유저 포지션 변경 메소드들
    public void moveUserPosition() {
        for (User user : this.users) {
            movePosition(user);
        }
    }

    public void movePosition(User user) {
        for (Line line : this.ladder) {
            isPositionFist(user,line.getLine());
            // 포지션 값을 리턴값으로
        }
    }

// 포지션값을 받아 view 에서 출력.
    public int movePosition2(User user) {
        int userPosition = user.getPosition();
        for (Line line : this.ladder) {
            userPosition = line.isMovePosition(userPosition);
            // 포지션 값을 리턴값으로
        }
        return userPosition;
    }

    public void isPositionFist(User user, ArrayList<Boolean> line) {
        if (user.isTrue(0)) {
            user.moveRight(line.get(0));
            return;
        }
        isPositionLast(user, line);
    }

    private void isPositionLast(User user, ArrayList<Boolean> line) {
        if (user.isTrue( this.users.size() - 1)) {
            user.moveLeft(line.get(line.size() - 1));
            return;
        }
        elsePosition(user, line);
    }

    // getPosition 안쓰고 구현할 수 없을까>?????
    private void elsePosition(User user, ArrayList<Boolean> line) {
        int thisPosition = user.getPosition();
        user.moveLeft(line.get(thisPosition - 1));
        user.moveRight(line.get(thisPosition));
    }

    public ArrayList<Line> getLadder() {
        return this.ladder;
    }

    public ArrayList<MyResult> getResults() {
        return this.results;
    }

}
