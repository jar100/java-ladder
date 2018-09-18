package laddergame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void isTrue() {
        for (int i = 0; i < 5; i++) {
            boolean random = LadderGame.isTrue();
            System.out.println(random);
        }
    }

    @Test
    public void makeLine() {
        String line = "";
        line = LadderGame.getOneLine(4);
        assertThat(line).isEqualTo("l-l l-l");
    }

    @Test
    public void line() {
        String line = LadderGame.lineOrblank(true);

        assertThat(line).isEqualTo("-");
    }
    @Test
    public void blank() {
        String line = LadderGame.lineOrblank(false);

        assertThat(line).isEqualTo(" ");
    }
}
