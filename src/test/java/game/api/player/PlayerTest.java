package game.api.player;

import game.api.domain.Sign;
import game.api.player.strategy.ConstantStrategy;
import game.api.player.strategy.GameStrategy;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PlayerTest {

    @Test
    public void checkComputerPlayerStrategy() {
        GameStrategy gameStrategy = new ConstantStrategy(Sign.ROCK);
        ComputerPlayer player = new ComputerPlayer(gameStrategy);
        Assert.assertEquals(gameStrategy, player.getGameStrategy());
    }

    @Test
    public void checkComputerPlayerSign() {
        GameStrategy gameStrategy = new ConstantStrategy(Sign.ROCK);
        ComputerPlayer player = new ComputerPlayer(gameStrategy);
        Assert.assertEquals(Sign.ROCK, player.getSign());
        player.setGameStrategy(new ConstantStrategy(Sign.PAPER));
        Assert.assertEquals(Sign.PAPER, player.getSign());
        player.setGameStrategy(new ConstantStrategy(Sign.SCISSORS));
        Assert.assertEquals(Sign.SCISSORS, player.getSign());
    }
}
