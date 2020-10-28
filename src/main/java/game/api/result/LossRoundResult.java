package game.api.result;

import game.api.player.Player;

public class LossRoundResult implements PlayerRoundResult {
    private Player player;

    public LossRoundResult(Player player) {
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return String.format("Player %d lost", player.getPlayerId());
    }

    @Override
    public int getScore() {
        return 0;
    }
}
