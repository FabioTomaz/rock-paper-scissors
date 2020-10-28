package game.api.player.strategy;

import game.api.sign.Sign;

import java.util.Random;

public class RandomStrategy implements GameStrategy {

    private static final String NAME = "Random Strategy";
    private static final String DESCRIPTION = "Randomly chooses between rock paper and scissors";

    private Random random;

    public RandomStrategy() {
        random = new Random();
    }

    @Override
    public String getName() {
        return RandomStrategy.NAME;
    }

    @Override
    public String getDescription() {
        return RandomStrategy.DESCRIPTION;
    }

    @Override
    public Sign getSign() {
        return Sign.SIGNS.get(this.random.nextInt(Sign.SIZE));
    }
}
