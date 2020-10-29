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
        LOGGER.info("---- SUMMARY ----");

        LOGGER.info("+-----------------------------------+");
        LOGGER.info(String.format(
                "| %-7S | %-10s | %-10s |",
                "ROUND",
                "PLAYER 1",
                "PLAYER 2"
        ));

        LOGGER.info("+-----------------------------------+");
        for (int i=0; i< game.getRounds().size(); i++) {
            Round round = game.getRounds().get(i);
            LOGGER.info(String.format(
                    "| %-7d | %-10s | %-10s |",
                    i+1,
                    round.getPlayerSigns().get(0),
                    round.getPlayerSigns().get(1)
            ));
        }

        LOGGER.info("+-----------------------------------+");
        LOGGER.info(String.format(
                "| %-7s | %-10d | %-10d |",
                "SCORES",
                game.getPlayers().get(0).getScore(),
                game.getPlayers().get(1).getScore()
        ));
        LOGGER.info("+-----------------------------------+");

        if (game.getWinner() != null) {
            LOGGER.info(String.format("PLAYER %d WINS!", game.getWinner().getPlayerId()));
        } else {
            LOGGER.info("DRAW!");
        }
    }

}
