package game.api.player;

import game.api.domain.Sign;

public class HumanPlayer extends Player {

    @Override
    public Sign getSign() {
        Sign sign = null;
        do {
            // Hide sign input from other players
            char[] ch = System.console().readPassword("Sign (R - ROCK, P - PAPER, S - SCISSORS): ");
            String signStr = new String(ch).toUpperCase();

            if ("R".equals(signStr)) {
                sign = Sign.ROCK;

            } else if ("P".equals(signStr)) {
                sign = Sign.PAPER;

            } else if ("S".equals(signStr)) {
                sign = Sign.SCISSORS;

            }
        } while (sign==null);

        return sign;
    }
}
