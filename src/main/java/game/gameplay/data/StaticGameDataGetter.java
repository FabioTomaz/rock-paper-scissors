package game.gameplay.data;

import game.api.player.Player;

import java.util.List;

public class StaticGameDataGetter implements GameDataGetter {

    private int rounds;

    private List<Player> players;

    public StaticGameDataGetter(int rounds, List<Player> players) {
        this.players = players;
        this.rounds = rounds;
    }

    @Override
    public int getRounds() {
        return this.rounds;
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }
}
