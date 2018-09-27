package laddergame.domain;

public class User {
    private String name;
    private  int position;

    public User(String name,int position) {
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
            this.position ++;
        }
    }

    public void moveLeft(boolean isTrue) {
        if (isTrue) {
            this.position --;
        }
    }
    /*
    //오른쪽확인 있으면(y값 증가)

    // 왼쪽확인 있으면 (y값 감소)

    public void isMovePosition(boolean b) {
        // true 좌우든 움직인다. 일단 y 증가 먼저 구현

        //false 아래로 내려간다. ( x값 증가)
    }
*/
}
