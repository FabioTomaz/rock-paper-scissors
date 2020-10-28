package game;

import game.gameplay.data.CommandLineDataGetter;
import game.gameplay.data.GameDataGetter;
import game.gameplay.lifecycle.Game;
import game.gameplay.logger.CustomConsoleLogger;
import game.gameplay.logger.GameLogger;

/**
 * Entry point for rock paper scissors game.
 */
public class App {
    public static void main(String[] args) {
        GameDataGetter gameDataGetter = new CommandLineDataGetter();
        GameLogger logger = new CustomConsoleLogger();

        Game game = new Game(gameDataGetter, logger);

        game.playGame();
    }
}
