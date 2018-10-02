package laddergame.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private static final int RANDOM_MAX_NUM = 10;
    private static final int IS_TRUE = 5;

    private ArrayList<Boolean> point;

    public Line(int countOfPerson) {
        this.point = makeLine(countOfPerson);
    }

    public Line(ArrayList<Boolean> points) {
        this.point = points;
    }

    public static ArrayList<Boolean> makeLine(int person) {
        ArrayList<Boolean> line = new ArrayList<>();
        boolean exception = false;
        for (int i = 0; i < person - 1; i++) {
            exception = isException(line, exception);
        }
        return line;
    }

    // exception 이 false 면 isTrue 호출 isTrue 를 리턴 exception 이 true 면 false 리턴
    private static boolean isException(ArrayList<Boolean> ladder, boolean exception) {
        if (!exception) {
            boolean addBoolean = isTrue();
            ladder.add(addBoolean);
            return addBoolean;
        }
        ladder.add(false);
        return false;
    }

    public static boolean isTrue() {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_MAX_NUM);
        return randomNum >= IS_TRUE;
    }

    // 테스트 코드용
    public Boolean isMove(int i) {
        return this.point.get(i);
    }

    public ArrayList<Boolean> getLine() {
        return this.point;
    }


    //user 와 result 매칭

    public int isMovePosition(int uerPosition) {
        if (isPositionFist(uerPosition)) {
           return isMoveRight(uerPosition);
        }
        if(isPositionLast(uerPosition)) {
            return  isMoveLeft(uerPosition);
        }
        return othersPosition(uerPosition);
    }

    private boolean isPositionLast(int uerPosition) {
        if (uerPosition == this.point.size()) {
            return true;
        }
        return false;
    }

    private  boolean isPositionFist(int userPosition) {
        if (userPosition == 0) {
            return true;
        }
        return false;
    }

    public int othersPosition(int userPosition) {
        if (this.point.get(userPosition - 1)) {
            return isMoveLeft(userPosition);
        }
        return isMoveRight(userPosition);
    }

    private int isMoveRight(int userPosition) {
        if (this.point.get(userPosition)) {
            userPosition++;
        }
        return userPosition;
    }

    private int isMoveLeft(int userPosition) {
        if (this.point.get(userPosition - 1)) {
            userPosition--;
        }
        return userPosition;
    }


}
