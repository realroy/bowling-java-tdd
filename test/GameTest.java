package test;

import main.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private void roll(int time, int pindown) {
        for (int i = 0; i < time; i++) {
            game.roll(pindown);
        }
    }

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void canMakeGame() {
        new Game();
    }

    @Test
    public void canRollBall() {
        roll(1, 0);
    }

    @Test
    public void canScoreGutterGame() {
        int[] pinDowns = new int[20];
        Arrays.fill(pinDowns, 0);
        assertEquals(game.roll(pinDowns).getScore(), 0);
    }

    @Test
    public void canScoreGameOfOne() {
        int[] pinDowns = new int[20];
        Arrays.fill(pinDowns, 1);
        assertEquals(game.roll(pinDowns).getScore(), 20);
    }

    @Test
    public void canScoreSpareFollowedByThree() {
        int[] pinDowns = new int[20];
        Arrays.fill(pinDowns, 0);
        pinDowns[0] = 5;
        pinDowns[1] = 5;
        pinDowns[2] = 3;
        assertEquals(game.roll(pinDowns).getScore(), 16);
    }

    @Test
    public void canScoreSpareFollowedByThreeThenThree() {
        int[] pinDowns = new int[20];
        Arrays.fill(pinDowns, 0);
        pinDowns[0] = 10;
        pinDowns[1] = 3;
        pinDowns[2] = 3;
        assertEquals(game.roll(pinDowns).getScore(), 22);
    }

    @Test
    public void canScorePerfectGame() {
        int[] pinDowns = new int[20];
        Arrays.fill(pinDowns, 10);
        assertEquals(game.roll(pinDowns).getScore(), 300);
    }

}
