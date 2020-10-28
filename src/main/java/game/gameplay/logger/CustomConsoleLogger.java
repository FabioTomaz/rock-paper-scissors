package game.gameplay.logger;

import game.api.player.Player;
import game.gameplay.lifecycle.Game;
import game.gameplay.lifecycle.Round;
import org.apache.log4j.Logger;

import java.util.List;

public class CustomConsoleLogger implements GameLogger {

    private static final Logger LOGGER = Logger.getLogger(CustomConsoleLogger.class);

    private List<Player> players;

    public CustomConsoleLogger(List<Player> players) {
        this.players = players;
    }

    @Override
    public void outputGameStart(Game game) {
        LOGGER.info("Starting game..");
    }

    @Override
    public void outputRoundStart(Round round) {
        LOGGER.info("---- ROUND START ----");
    }

    @Override
    public void outputPlayerWait(Player player) {
        LOGGER.info(String.format("Waiting for player %d...", player.getPlayerId()));
    }

    @Override
    public void outputRoundSummary(Round round) {
        for (int i = 0; i < players.size(); i++) {
            LOGGER.info(String.format(
                    "Player %d plays %s",
                    players.get(i).getPlayerId(),
                    round.getPlayerSigns().get(i)
            ));
        }
        LOGGER.info(round.getRoundResult());
        LOGGER.info("---- ROUND END ----");
    }

    @Override
    public void outputGameSummary(Game game) {
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
