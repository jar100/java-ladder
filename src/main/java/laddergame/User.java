package laddergame;

public class User {

    private int xPosition = 0;
    private int yPosition = 0;
    private String name;

    public User(String name,int position) {
        this.name = name;
        this.yPosition = position;
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public String getName() {
        return this.name;
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
