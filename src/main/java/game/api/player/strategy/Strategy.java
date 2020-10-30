package game.api.player.strategy;

import game.api.domain.Sign;

/**
 * Contract for a computer player strategy
 */
public interface Strategy {
    String getName();

    String getDescription();

    Sign getSign();
}
