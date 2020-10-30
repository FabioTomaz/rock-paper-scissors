package game.api.player;

import game.api.domain.Sign;
import game.api.player.strategy.Strategy;

import java.util.Objects;

/**
 * Simple computer player with game strategy
 */
public class ComputerPlayer extends Player {

    private Strategy strategy;

    public ComputerPlayer(Strategy strategy) {
        super();
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public Sign getSign() {
        return this.strategy.getSign();
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
        return Objects.equals(strategy, that.strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), strategy);
    }
}
