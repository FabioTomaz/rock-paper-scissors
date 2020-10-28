package game.api.player;

import game.api.sign.Sign;
import game.api.player.strategy.GameStrategy;

public class ComputerPlayer extends Player {
    private final GameStrategy gameStrategy;

    public ComputerPlayer(GameStrategy gameStrategy) {
        super();
        this.gameStrategy = gameStrategy;
    }


    public GameStrategy getGameStrategy() {
        return gameStrategy;
    }

    @Override
    public Sign getSign() {
        return this.gameStrategy.getSign();
    }
}
