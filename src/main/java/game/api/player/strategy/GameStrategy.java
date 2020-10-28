package game.api.player.strategy;

import game.api.domain.Sign;

public interface GameStrategy {
    String getName();

    String getDescription();

    Sign getSign();
}
