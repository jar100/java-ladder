package laddergame;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    static final String SEPARATOR = ",";
    private int person = 0;
    private int height = 0;
    private List<ArrayList> ladder = new ArrayList<>();
    private User[] users;

    public LadderGame(String members, int height) {
        this.users = userNames(members.split(SEPARATOR));
        this.person = users.length;
        this.height = height;
    }

    public static User[] userNames(String[] names) {
        User[] users = new User[names.length];
        for (int i = 0; i < names.length; i++) {
            users[i] = new User(names[i], i);
        }
        return users;
    }

    public User[] getUser() {
        return this.users;
    }

    public void run() {
        ladder = Ladder.makeLadder(this.person, this.height);
    }

    public List<ArrayList> getLadder() {
        return ladder;
    }

}
