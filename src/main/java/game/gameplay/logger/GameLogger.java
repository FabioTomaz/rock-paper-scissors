package game.gameplay.logger;

import game.api.player.Player;
import game.gameplay.lifecycle.Game;
import game.gameplay.lifecycle.Round;

/**
 * Contract for logging game information to the user interface
 */
public interface GameLogger {

    /**
     * Logs start of game
     */
    void gameStart(Game game);

    /**
     * Logs start of round
     */
    void roundStart(Round round);

    /**
     * Logs player wait information
     */
    void playerWait(Player player);

    /**
     * Logs summary of round results
     */
    void roundSummary(Round round);

    /**
     * Logs summary of game results
     */
    void gameSummary(Game game);

}

