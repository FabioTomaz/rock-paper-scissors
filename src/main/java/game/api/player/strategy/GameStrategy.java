package game.api.player.strategy;

import game.api.domain.Sign;

/**
 * Contract for a computer player strategy
 */
public interface GameStrategy {
    String getName();

    String getDescription();

    Sign getSign();
}
