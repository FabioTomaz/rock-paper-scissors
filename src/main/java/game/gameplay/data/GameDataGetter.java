package game.gameplay.data;

import game.api.player.Player;

import java.util.List;

/**
 * Contract for retrieving data for game related configuration parameters
 */
public interface GameDataGetter {
    int getRounds();

    List<Player> getPlayers(int nPlayers);
}
