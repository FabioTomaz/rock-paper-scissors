package game.api.player;

import game.api.domain.Sign;
import game.api.player.strategy.GameStrategy;

import java.util.Objects;

/**
 * Simple computer player with game strategy
 */
public class ComputerPlayer extends Player {

    private GameStrategy gameStrategy;

    public ComputerPlayer(GameStrategy gameStrategy) {
        super();
        this.gameStrategy = gameStrategy;
    }

    public void setGameStrategy(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public GameStrategy getGameStrategy() {
        return gameStrategy;
    }

    @Override
    public Sign getSign() {
        return this.gameStrategy.getSign();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ComputerPlayer that = (ComputerPlayer) o;
        return Objects.equals(gameStrategy, that.gameStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gameStrategy);
    }
}
