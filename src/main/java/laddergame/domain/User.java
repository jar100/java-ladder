package laddergame.domain;

public class User {
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.name == obj);
    }


}
