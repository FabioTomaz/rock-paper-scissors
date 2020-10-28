package game.api.result;

import game.api.player.Player;

public interface PlayerRoundResult extends RoundResult {
    Player getPlayer();
}
