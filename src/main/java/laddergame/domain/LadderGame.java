package laddergame.domain;

import java.util.ArrayList;

public class LadderGame {
    static final String SEPARATOR = ", |,";
    private int person = 0;
    private int height = 0;
    private ArrayList<Line> ladder = new ArrayList<>();
    private ArrayList<User> users;
    private ArrayList<MyResult> results;

    public LadderGame() {

    }

    public LadderGame(String members, int height, String results) {
        this.users = makeUsers(members.split(SEPARATOR));
        this.person = users.size();
        this.height = height;
        this.results = makeResults(results.split(SEPARATOR));
    }

    private ArrayList<MyResult> makeResults(String[] results) {
        ArrayList<MyResult> myResults = new ArrayList<>();
        for (int i = 0; i < results.length; i++) {
            myResults.add(new MyResult(results[i], i));
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

    public void run() {
        for (int i = 0; i < this.height; i++) {
            ladder.add(new Line(this.person));
        }
    }

    public void run2() {
        for (int i = 0; i < this.users.size(); i++) {
            movePosition3(this.users.get(i), this.ladder);
        }
    }

    public void movePosition3(User user, ArrayList<Line> ladders) {
        for (int i = 0; i < ladders.size(); i++) {
            // System.out.println("시작스");
            isPositionFist(user, ladders.get(i).getLine());
            System.out.print(user.getPosition());
        }
        System.out.println();
    }

    public void isPositionFist(User user, ArrayList<Boolean> line2) {
        if (user.getPosition() == 0) {
            user.moveRight(line2.get(0));
            return;
        }
        isPositionLast(user, line2);
    }

    private void isPositionLast(User user, ArrayList<Boolean> line2) {
        if (user.getPosition() == this.users.size() - 1) {
            user.moveLeft(line2.get(line2.size() - 1));
            return;
        }
        elsePosition(user, line2);
    }

    private void elsePosition(User user, ArrayList<Boolean> line2) {
        int thisPosition = user.getPosition();
        user.moveLeft(line2.get(thisPosition - 1));
        user.moveRight(line2.get(thisPosition));
    }

    public ArrayList<Line> getLadder() {
        return this.ladder;
    }

    public ArrayList<MyResult> getResults() {
        return this.results;
    }

}
