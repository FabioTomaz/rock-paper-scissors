package game.gameplay.data;

import game.api.player.ComputerPlayer;
import game.api.player.Player;
import game.api.player.strategy.ConstantStrategy;
import game.api.player.strategy.GameStrategy;
import game.api.player.strategy.RandomStrategy;
import game.api.domain.Sign;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Command line based data getter for games with console interaction
 */
public class CommandLineDataGetter implements GameDataGetter {

    private static final Logger LOGGER = Logger.getLogger(CommandLineDataGetter.class);

    private static final GameStrategy[] AVAILABLE_STRATEGIES = {
            new RandomStrategy(),
            new ConstantStrategy(Sign.ROCK),
            new ConstantStrategy(Sign.PAPER),
            new ConstantStrategy(Sign.SCISSORS),
    };

    @Override
    public int getRounds() {
        return this.readNumber("Enter number of rounds: ", 1, null);
    }

    @Override
    public List<Player> getPlayers(int nPlayers) {
        List<Player> players = new ArrayList<>(nPlayers);

        LOGGER.info("---- Available Strategies ----");
        for (int i = 0; i < AVAILABLE_STRATEGIES.length; i++) {
            LOGGER.info(String.format(
                    "%d) %s -> %s",
                    i,
                    AVAILABLE_STRATEGIES[i].getName(),
                    AVAILABLE_STRATEGIES[i].getDescription()
            ));
        }
        LOGGER.info("------------------------------");

        for (int i = 0; i < nPlayers; i++) {
            GameStrategy gameStrategy = this.askPlayerStrategy(i + 1);
            players.add(new ComputerPlayer(gameStrategy));
        }
        return players;
    }

    private GameStrategy askPlayerStrategy(int playerNumber) {
        String message = String.format(
                "Enter strategy for player %d (0-%d): ",
                playerNumber,
                AVAILABLE_STRATEGIES.length - 1
        );

        int strategyIndex = this.readNumber(message, 0, AVAILABLE_STRATEGIES.length);

        return AVAILABLE_STRATEGIES[strategyIndex];
    }

    private int readNumber(String msg, Integer min, Integer max) {
        Scanner scanner = new Scanner(System.in);
        String str;
        int number;
        while (true) {
            try {
                LOGGER.info(msg);
                str = scanner.nextLine();
                number = Integer.parseInt(str);
                if ((min == null || number >= min) && (max == null || number < max)) {
                    break;
                }
            } catch (Exception e) {
                LOGGER.error("Not a valid number!");
            }
            LOGGER.error(String.format(
                    "Number range - Min: %d Max: %s",
                    min != null ? min : 0,
                    max != null ? max-1 : ""
            ));
        }
        return number;
    }
}
