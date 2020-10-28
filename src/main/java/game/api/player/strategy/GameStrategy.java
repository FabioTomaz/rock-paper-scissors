package game.api.player.strategy;

import game.api.sign.Sign;

public interface GameStrategy {
    String getName();

    String getDescription();

    Sign getSign();
}
