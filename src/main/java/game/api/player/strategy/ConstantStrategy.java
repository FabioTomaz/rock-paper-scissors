package game.api.player.strategy;

import game.api.domain.Sign;

/**
 * Strategy that always chooses the same sign to play
 */
public class ConstantStrategy implements GameStrategy {

    private static final String NAME = "%s Strategy";
    private static final String DESCRIPTION = "Always plays %s";

    private Sign sign;

    public ConstantStrategy(Sign sign) {
        this.sign = sign;
    }

    @Override
    public String getName() {
        return String.format(ConstantStrategy.NAME, this.sign);
    }

    @Override
    public String getDescription() {
        return String.format(ConstantStrategy.DESCRIPTION, this.sign);
    }

    @Override
    public Sign getSign() {
        return this.sign;
    }
}
