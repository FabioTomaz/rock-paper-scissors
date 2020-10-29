package game.gameplay.logger;

import game.api.player.Player;
import game.gameplay.lifecycle.Game;
import game.gameplay.lifecycle.Round;

/**
 * Contract for logging game information to the user interface
 */
public interface GameLogger {
    void outputGameStart(Game game);

    void outputRoundStart(Round round);

    void outputPlayerWait(Player player);

    void outputRoundSummary(Round round);

    void outputGameSummary(Game game);
}

