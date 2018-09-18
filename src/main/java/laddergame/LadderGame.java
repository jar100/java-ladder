package laddergame;

import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        int person = inputPeple();
        int height = inputHeight();
        String[] lines = makeHeight(person, height);
        getHeight(lines);
    }

    public static int inputPeple() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명 인가요?");
        return scanner.nextInt();
    }

    public static int inputHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
        }

    public static void resultView(int peples, int height) {
        System.out.println("인간수 " + peples + " 사다리 높이 " + height);
    }

    public static boolean isTrue() {
        Random random = new Random();
        int randomDraw = random.nextInt(10);
        return randomDraw >= 5;
    }

    public static String lineOrblank(boolean isTrue) {
        String line = " ";
        if(isTrue) {
            line = "-";
        }
        return line;
    }

    public static String[] makeHeight(int person, int height) {
        String[] lines = new String[height];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = getOneLine(person);
        }
        return lines;
    }

    // l- 를 동시에 출력하다가 마지막만 l 출력
    public static String getOneLine(int person) {
        String line = "";
        for (int i = 0; i < person; i++) {
            line += "l";
            if( i != (person-1)) {
                line += lineOrblank(isTrue());
            }
        }
        return line;
    }

    public static void getHeight(String[] lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
