package game.gameplay.data;

import game.api.player.Player;

import java.util.List;

/**
 * Static data getter for pre-configured games
 */
public class StaticDataGetter implements GameDataGetter {

    private int rounds;

    private List<Player> players;

    public StaticDataGetter(int rounds, List<Player> players) {
        this.players = players;
        this.rounds = rounds;
    }

    @Override
    public int getRounds() {
        return this.rounds;
    }

    @Override
    public List<Player> getPlayers(int nPlayers) {
        return this.players;
    }
}
