package game.gameplay;

import game.api.player.ComputerPlayer;
import game.api.player.Player;
import game.api.player.strategy.ConstantStrategy;
import game.api.domain.Sign;
import game.gameplay.data.GameDataGetter;
import game.gameplay.data.StaticGameDataGetter;
import game.gameplay.lifecycle.Game;
import game.gameplay.logger.CustomConsoleLogger;
import game.gameplay.logger.GameLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class GameTest {

    private Game game;

    private List<Player> players;

    private GameDataGetter gameDataGetter;

    @Before
    public void setup() {
        List<Player> players = new ArrayList<>();
        players.add(new ComputerPlayer(new ConstantStrategy(Sign.ROCK)));
        players.add(new ComputerPlayer(new ConstantStrategy(Sign.PAPER)));
        this.players = players;

        this.gameDataGetter = new StaticGameDataGetter(3, players);
        GameLogger consoleLogger = new CustomConsoleLogger();
        this.game = new Game( this.gameDataGetter, consoleLogger);
        this.game.playGame();
    }

    @Test
    public void checkGameWinner() {
        Assert.assertEquals(this.players.get(1), this.game.getWinner());
    }

    @Test
    public void checkPlayerScores() {
        Assert.assertEquals(0, this.game.getPlayers().get(0).getScore());
        Assert.assertEquals(6, this.game.getPlayers().get(1).getScore());
    }

    @Test
    public void checkGamePlayers() {
        Assert.assertEquals(this.players, this.game.getPlayers());
    }

    @Test
    public void checkGameRounds() {
        Assert.assertEquals(gameDataGetter.getRounds(), this.game.getNRounds());
    }

}
