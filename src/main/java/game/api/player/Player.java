package game.api.player;

import game.api.sign.Sign;

import java.util.Observable;

public abstract class Player extends Observable {
    private static int currentId = 1;

    private final int playerId;

    private int score;

    Player() {
        this.playerId = Player.currentId++;
        this.score = 0;
    }

    public int getPlayerId() {
        return playerId;
    }

    public final int getScore() {
        return score;
    }

    public final void setScore(int score) {
        this.score = score;
    }

    public abstract Sign getSign();

}
