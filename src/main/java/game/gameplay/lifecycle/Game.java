package game.gameplay.lifecycle;

import game.api.player.Player;
import game.gameplay.data.GameDataGetter;
import game.gameplay.logger.GameLogger;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int PLAYERS_NUMBER = 2;

    // Developer Game customization
    private GameDataGetter gameDataGetter;
    private GameLogger logger;

    // Player customization
    private int nRounds;
    private List<Player> players;

    // Lifecycle rounds
    private List<Round> rounds;

    // Game results
    private Player winner;

    public Game(GameDataGetter gameStarter, GameLogger logger) {
        this.gameDataGetter = gameStarter;
        this.logger = logger;
        this.rounds = new ArrayList<>();
    }

    public void playGame() {
        this.startGame();
        this.playRounds();
        this.finishGame();
    }

    private void startGame() {
        this.logger.outputGameStart(this);
        this.players = this.gameDataGetter.getPlayers(PLAYERS_NUMBER);
        this.nRounds = this.gameDataGetter.getRounds();
    }

    private void playRounds() {
        for (int i = 0; i < this.nRounds; i++) {
            Round round = new Round(this.players, this.logger);
            round.playRound();
            this.rounds.add(round);
        }
    }

    private void finishGame() {
        this.winner = this.determineWinner();
        this.logger.outputGameSummary(this);
    }

    private Player determineWinner() {
        Player firstPlayer = players.get(0);
        Player secondPlayer = players.get(1);

        if (firstPlayer.getScore() > secondPlayer.getScore()) {
            return firstPlayer;
        } else if (secondPlayer.getScore() > firstPlayer.getScore()) {
            return secondPlayer;
        } else {
            return null;
        }
    }

    public int getNRounds() {
        return nRounds;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public Player getWinner() {
        return winner;
    }
}
