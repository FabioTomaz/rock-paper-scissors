package game.api.player;

import game.api.domain.Sign;

import java.util.Objects;
import java.util.Observable;

/**
 * Simple class representing a player
 */
public abstract class Player extends Observable {
    private static int currentId = 0;

    private final int playerId;

    private int score;

    Player() {
        this.playerId = ++Player.currentId;
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

    /**
     * Determines the sign that the player will play
     * @return Sign played
     */
    public abstract Sign getSign();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return playerId == player.playerId &&
                score == player.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, score);
    }
}
