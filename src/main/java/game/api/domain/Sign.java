package game.api.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Enum representing the all the possible game signs
 */
public enum Sign {
    PAPER {
        @Override
        public Sign beats() {
            return Sign.ROCK;
        }

        @Override
        public Sign beatenBy() {
            return Sign.SCISSORS;
        }
    },
    ROCK {
        @Override
        public Sign beats() {
            return Sign.SCISSORS;
        }

        @Override
        public Sign beatenBy() {
            return Sign.PAPER;
        }
    },
    SCISSORS {
        @Override
        public Sign beats() {
            return Sign.PAPER;
        }

        @Override
        public Sign beatenBy() {
            return Sign.ROCK;
        }
    };

    /**
     * Determines the result of confrontation between this sign and other sign
     * @param sign the opposite sign
     * @return Result of sign confrontation
     */
    public Result against(Sign sign) {
        if (sign == beats()) {
            return Result.WINS;
        } else if (sign == beatenBy()) {
            return Result.LOSES;
        } else {
            return Result.DRAW;
        }
    }

    /**
     * @return the Sign that this sign beats
     */
    public abstract Sign beats();

    /**
     * @return the Sign that this sign is beaten by
     */
    public abstract Sign beatenBy();

    public static final List<Sign> SIGNS = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = SIGNS.size();
}
