package game.api.domain;

import game.api.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Enum representing the round result
 */
public class RoundResult {

    private static final Map<Result, Integer> RESULT_SCORES = new HashMap<>();
    static {
        RESULT_SCORES.put(Result.DRAW, 1);
        RESULT_SCORES.put(Result.LOSES, 0);
        RESULT_SCORES.put(Result.WINS, 2);
    }

    private Result result;

    private Player player;

    public RoundResult(Result result, Player player) {
        this.player = player;
        this.result = result;
    }

    public RoundResult(Result result) {
        this.result = result;
    }

    public Player getPlayer() {
        return player;
    }

    public int getScore() {
        return RESULT_SCORES.get(this.result);
    }

    public String toString() {
        if(this.player != null) {
            return String.format("Player %d %s", this.player.getPlayerId(), this.result);
        }
        return this.result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoundResult that = (RoundResult) o;
        return result == that.result &&
                Objects.equals(player, that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, player);
    }
}
