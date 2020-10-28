package game.gameplay.lifecycle;

import game.api.player.Player;
import game.api.result.DrawRoundResult;
import game.api.result.PlayerRoundResult;
import game.api.result.RoundResult;
import game.api.result.WinRoundResult;
import game.api.sign.Result;
import game.api.sign.Sign;
import game.gameplay.logger.GameLogger;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private final GameLogger logger;

    private final List<Player> players;
    private List<Sign> playerSigns;

    private RoundResult roundResult = null;

    Round(List<Player> players, GameLogger logger) {
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

    private void updatePlayerScores() {
        if (roundResult instanceof PlayerRoundResult) {
            Player resultPlayer = ((PlayerRoundResult) roundResult).getPlayer();
            resultPlayer.setScore(resultPlayer.getScore() + roundResult.getScore());
        } else {
            for (Player player : players) {
                player.setScore(player.getScore() + roundResult.getScore());
            }
        }
    }

    public List<Sign> getPlayerSigns() {
        return this.playerSigns;
    }

    public RoundResult getRoundResult() {
        return this.roundResult;
    }

    private RoundResult determineRoundResult() {
        RoundResult result;
        if (playerSigns.get(0).against(playerSigns.get(1)) == Result.WINS) {
            result = new WinRoundResult(players.get(0));
        } else if (playerSigns.get(1).against(playerSigns.get(0)) == Result.WINS) {
            result = new WinRoundResult(players.get(1));
        } else {
            result = new DrawRoundResult();
        }
        return result;
    }

}
