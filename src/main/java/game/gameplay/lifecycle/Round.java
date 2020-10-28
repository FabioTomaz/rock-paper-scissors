package game.gameplay.lifecycle;

import game.api.domain.Result;
import game.api.domain.RoundResult;
import game.api.domain.Sign;
import game.api.player.Player;
import game.gameplay.logger.GameLogger;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private static int currentRound = 0;

    private final int roundNumber;

    private final GameLogger logger;

    private final List<Player> players;
    private List<Sign> playerSigns;

    private RoundResult roundResult = null;

    Round(List<Player> players, GameLogger logger) {
        this.roundNumber = ++Round.currentRound;
        this.players = players;
        this.logger = logger;
        this.playerSigns = new ArrayList<>(players.size());
    }

    void playRound() {
        this.logger.outputRoundStart(this);
        for (Player player : this.players) {
            this.logger.outputPlayerWait(player);
            Sign sign = player.getSign();
            int playerIndex = this.players.indexOf(player);
            this.playerSigns.add(playerIndex, sign);
        }
        this.finishRound();
    }

    private void finishRound() {
        this.roundResult = this.determineRoundResult();
        this.updatePlayerScores();
        this.logger.outputRoundSummary(this);
    }

    private RoundResult determineRoundResult() {
        RoundResult result;
        if (playerSigns.get(0).against(playerSigns.get(1)) == Result.WINS) {
            result = new RoundResult(Result.WINS, players.get(0));
        } else if (playerSigns.get(1).against(playerSigns.get(0)) == Result.WINS) {
            result = new RoundResult(Result.WINS, players.get(1));
        } else {
            result = new RoundResult(Result.DRAW);
        }
        return result;
    }


    private void updatePlayerScores() {
        if (roundResult.getPlayer() != null) {
            Player resultPlayer = roundResult.getPlayer();
            resultPlayer.setScore(resultPlayer.getScore() + roundResult.getScore());
        } else {
            for (Player player : players) {
                player.setScore(player.getScore() + roundResult.getScore());
            }
        }
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<Sign> getPlayerSigns() {
        return this.playerSigns;
    }

    public RoundResult getRoundResult() {
        return this.roundResult;
    }

    public int getRoundNumber() {
        return this.roundNumber;
    }

}
