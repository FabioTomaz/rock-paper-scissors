package game.gameplay.data;

import game.api.player.Player;

import java.util.List;

/**
 * Contract for retrieving data for game related configuration parameters
 */
public interface GameDataGetter {

    /**
     * Ask for number of game rounds
     * @return number of rounds
     */
    int getRounds();

    /**
     * Ask for game players
     * @param nPlayers number of players
     * @return List of game players
     */
    List<Player> getPlayers(int nPlayers);
}
