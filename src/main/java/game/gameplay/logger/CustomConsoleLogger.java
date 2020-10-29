package game.gameplay.logger;

import game.api.player.Player;
import game.gameplay.lifecycle.Game;
import game.gameplay.lifecycle.Round;
import org.apache.log4j.Logger;

/**
 * Custom console based logger
 */
public class CustomConsoleLogger implements GameLogger {

    private static final Logger LOGGER = Logger.getLogger(CustomConsoleLogger.class);

    @Override
    public void gameStart(Game game) {
        LOGGER.info(String.format("Starting game (%d rounds)...", game.getNRounds()));
    }

    @Override
    public void roundStart(Round round) {
        LOGGER.info(String.format("---- ROUND %d START ----", round.getRoundNumber()));
    }

    @Override
    public void playerWait(Player player) {
        LOGGER.info(String.format("Waiting for player %d...", player.getPlayerId()));
    }

    @Override
    public void roundSummary(Round round) {
        for (int i = 0; i < round.getPlayers().size(); i++) {
            LOGGER.info(String.format(
                    "Player %d plays %s",
                    round.getPlayers().get(i).getPlayerId(),
                    round.getPlayerSigns().get(i)
            ));
        }
        LOGGER.info(round.getRoundResult());
        LOGGER.info("---- ROUND END ----");
    }

    @Override
    public void gameSummary(Game game) {
        LOGGER.info("---- GAME END ----");
        LOGGER.info("---- SCORES ----");

        for (Player player : game.getPlayers()) {
            LOGGER.info(String.format("Player %d scores %d points", player.getPlayerId(), player.getScore()));
        }

        if (game.getWinner() != null) {
            LOGGER.info(String.format("Player %d wins", game.getWinner().getPlayerId()));
        } else {
            LOGGER.info("DRAW!");
        }
    }

}
