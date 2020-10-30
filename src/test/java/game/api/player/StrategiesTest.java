package game.api.player;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import game.api.player.strategy.RandomStrategy;
import game.api.domain.Sign;
import game.api.player.strategy.Strategy;
import game.api.player.strategy.ConstantStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit tests for computer player strategies
 */
public class StrategiesTest {

    @Test
    public void checkConstantStrategyPlaysRock() {
        this.checkConstantStrategy(Sign.ROCK);
    }

    @Test
    public void checkConstantStrategyPlaysPaper() {
        this.checkConstantStrategy(Sign.PAPER);
    }

    @Test
    public void checkConstantStrategyPlaysScissor() {
        this.checkConstantStrategy(Sign.SCISSORS);
    }

    private void checkConstantStrategy(Sign sign) {
        Strategy strategy = new ConstantStrategy(sign);
        for (int i=0; i<100; i++) {
            Assert.assertEquals(sign, strategy.getSign());
        }
    }

    @Test
    public void checkRandomStrategyPlaysSign() {
        Strategy strategy = new RandomStrategy();
        int N = 1000;
        for(int i = 0; i < N; i++) {
            Sign sign = strategy.getSign();
            assertNotNull(sign);
            assertTrue(sign.equals(Sign.ROCK) || sign.equals(Sign.PAPER) || sign.equals(Sign.SCISSORS));
        }
    }

    @Test
    public void checkRandomStrategyPlaysRandomSigns() {
        Strategy strategy = new RandomStrategy();
        Map<Sign, Integer> map = new HashMap<>();
        map.put(Sign.ROCK, 0);
        map.put(Sign.PAPER, 0);
        map.put(Sign.SCISSORS, 0);
        int N = 10000;
        double minPercentage = 1/(double)map.size() - 0.1;
        double maxPercentage = 1/(double)map.size() + 0.1;
        for(int i = 0; i < N; i++) {
            Sign sign = strategy.getSign();
            map.put(sign, map.get(sign) + 1);
        }
        for(Map.Entry<Sign, Integer> entry: map.entrySet()) {
            Assert.assertTrue((double)entry.getValue()/N > minPercentage && (double)entry.getValue()/N < maxPercentage);
        }
    }
}
