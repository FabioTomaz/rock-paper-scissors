package game.gameplay.data;

import game.api.player.Player;

import java.util.List;

public interface GameDataGetter {
    int getRounds();

    List<Player> getPlayers();
}
