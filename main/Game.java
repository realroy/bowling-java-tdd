package main;

public class Game {
    private int roll;
    private int[] rolls;

    public Game() {
        this.roll = 0;
        this.rolls = new int[21];
    }

    public Game roll(int[] pinDowns) {
        for (int pinDown: pinDowns) roll(pinDown);
        return this;
    }

    public Game roll(int pinsDown) {
        rolls[roll++] = pinsDown;
        return this;
    }

    public int getScore() {
        int score = 0;
        int cursor = 0;
        for (int frame = 0; frame < 10 ; frame++) {
            if (isStrike(cursor)){
                score += 10 + rolls[cursor + 1] + rolls[cursor+2];
                cursor++;
            } else if(isSpare(cursor)){
                score += (10 + rolls[cursor + 2]);
                cursor += 2;
            } else {
                score += rolls[cursor] + rolls[cursor+1];
                cursor += 2;
            }
        }
        return score;

    }

    private boolean isStrike(int cursor) {
        return rolls[cursor] == 10;
    }

    private boolean isSpare(int cursor) {
        return rolls[cursor] + rolls[cursor+1] == 10;
    }
}
