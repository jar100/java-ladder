package laddergame.domain;

public class User {
    private String name;
    private int position;

    public User(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveRight(boolean isTrue) {
        if (isTrue) {
            this.position++;
        }
    }

    public void moveLeft(boolean isTrue) {
        if (isTrue) {
            this.position--;
        }
    }

}
