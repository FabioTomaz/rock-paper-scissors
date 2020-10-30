package game.api.player;

import game.api.domain.Sign;
import game.api.player.strategy.ConstantStrategy;
import game.api.player.strategy.Strategy;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for different types of players
 */
public class PlayerTest {

    @Test
    public void checkComputerPlayerStrategy() {
        Strategy strategy = new ConstantStrategy(Sign.ROCK);
        ComputerPlayer player = new ComputerPlayer(strategy);
        Assert.assertEquals(strategy, player.getStrategy());
    }

    @Test
    public void checkComputerPlayerSign() {
        Strategy strategy = new ConstantStrategy(Sign.ROCK);
        ComputerPlayer player = new ComputerPlayer(strategy);
        Assert.assertEquals(Sign.ROCK, player.getSign());
        player.setStrategy(new ConstantStrategy(Sign.PAPER));
        Assert.assertEquals(Sign.PAPER, player.getSign());
        player.setStrategy(new ConstantStrategy(Sign.SCISSORS));
        Assert.assertEquals(Sign.SCISSORS, player.getSign());
    }
}
