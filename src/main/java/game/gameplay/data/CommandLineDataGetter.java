package game.gameplay.data;

import game.api.player.ComputerPlayer;
import game.api.player.Player;
import game.api.player.strategy.ConstantStrategy;
import game.api.player.strategy.GameStrategy;
import game.api.player.strategy.RandomStrategy;
import game.api.sign.Sign;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        int nRounds;
        do {
            Scanner scanner = new Scanner(System.in);

            LOGGER.info("Enter number of rounds: ");
            nRounds = scanner.nextInt();
        } while (nRounds <= 0);

        return nRounds;
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>(2);

        LOGGER.info("---- Available Strategies ----");
        for(int i=0; i<=AVAILABLE_STRATEGIES.length; i++) {
            LOGGER.info(String.format("%d) %s -> %s", i, AVAILABLE_STRATEGIES[i].getName(), AVAILABLE_STRATEGIES[i].getDescription()));
        }
        LOGGER.info("------------------------------");

        for(int i=0; i<=AVAILABLE_STRATEGIES.length; i++) {
            GameStrategy gameStrategy = this.askPlayerStrategy(i);
            players.add(new ComputerPlayer(gameStrategy));
        }
        return players;
    }

    private GameStrategy askPlayerStrategy(int playerNumber) {
        int strategyIndex;
        do {
            Scanner scanner = new Scanner(System.in);
            LOGGER.info(String.format(
                    "Enter strategy for player %d (0-%d): ",
                    playerNumber,
                    AVAILABLE_STRATEGIES.length-1
            ));
            strategyIndex = scanner.nextInt();
        } while (strategyIndex <= AVAILABLE_STRATEGIES.length);

        return AVAILABLE_STRATEGIES[strategyIndex];
    }
}
