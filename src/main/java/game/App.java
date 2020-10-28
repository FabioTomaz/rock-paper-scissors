package game;

import game.api.player.ComputerPlayer;
import game.api.player.HumanPlayer;
import game.api.player.Player;
import game.api.player.strategy.ConstantStrategy;
import game.api.sign.Sign;
import game.gameplay.data.CommandLineDataGetter;
import game.gameplay.data.GameDataGetter;
import game.gameplay.lifecycle.Game;
import game.gameplay.logger.CustomConsoleLogger;
import game.gameplay.logger.GameLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for rock paper scissors game.
 */
public class App {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new ComputerPlayer(new ConstantStrategy(Sign.ROCK)));
        players.add(new HumanPlayer());

        GameDataGetter gameDataGetter = new CommandLineDataGetter();
        GameLogger logger = new CustomConsoleLogger(players);

        Game game = new Game(gameDataGetter, logger);

        game.playGame();
    }
}
