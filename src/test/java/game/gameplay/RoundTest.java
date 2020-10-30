package game.gameplay;

import game.api.domain.Result;
import game.api.domain.RoundResult;
import game.api.domain.Sign;
import game.api.player.ComputerPlayer;
import game.api.player.Player;
import game.api.player.strategy.ConstantStrategy;
import game.gameplay.data.GameDataGetter;
import game.gameplay.data.StaticDataGetter;
import game.gameplay.lifecycle.Game;
import game.gameplay.lifecycle.Round;
import game.gameplay.logger.CustomConsoleLogger;
import game.gameplay.logger.GameLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  Unit tests for round lifecycle related logic.
 */
public class RoundTest {

    private Game game;
    private Round round;

    private List<Player> players;

    @Before
    public void setup() {
        List<Player> players = new ArrayList<>();
        players.add(new ComputerPlayer(new ConstantStrategy(Sign.ROCK)));
        players.add(new ComputerPlayer(new ConstantStrategy(Sign.PAPER)));
        this.players = players;

        GameDataGetter gameDataGetter = new StaticDataGetter(1, players);
        GameLogger consoleLogger = new CustomConsoleLogger();
        this.game = new Game(gameDataGetter, consoleLogger);
        this.game.playGame();
        this.round = this.game.getRounds().get(0);
    }

    @Test
    public void checkGameRoundPlayerSigns() {
        List<Sign> signs = new ArrayList<>(2);
        signs.add(Sign.ROCK);
        signs.add(Sign.PAPER);
        Assert.assertEquals(signs, this.round.getPlayerSigns());
    }

    @Test
    public void checkGamePlayers() {
        Assert.assertEquals(this.players, this.game.getPlayers());
    }

    @Test
    public void checkGameRoundResult() {
        RoundResult roundResult = new RoundResult(Result.WINS, this.players.get(1));
        Assert.assertEquals(roundResult, this.round.getRoundResult());
    }

}
