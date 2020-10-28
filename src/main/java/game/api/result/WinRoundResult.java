package game.api.result;

import game.api.player.Player;

public class WinRoundResult implements PlayerRoundResult {
    private Player player;

    public WinRoundResult(Player player) {
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return String.format("Player %d won", player.getPlayerId());
    }

    @Override
    public int getScore() {
        return 1;
    }
}
