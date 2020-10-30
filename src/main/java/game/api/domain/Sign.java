package game.api.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Enum representing the all the possible game signs
 */
public enum Sign {
    PAPER {
        @Override
        public Set<Sign> beats() {
            return Sign.signSet(Sign.ROCK);
        }

        @Override
        public Set<Sign> beatenBy() {
            return Sign.signSet(Sign.SCISSORS);
        }
    },
    ROCK {
        @Override
        public Set<Sign> beats() {
            return Sign.signSet(Sign.SCISSORS);
        }

        @Override
        public Set<Sign> beatenBy() {
            return Sign.signSet(Sign.PAPER);
        }
    },
    SCISSORS {
        @Override
        public Set<Sign> beats() {
            return Sign.signSet(Sign.PAPER);
        }

        @Override
        public Set<Sign> beatenBy() {
            return Sign.signSet(Sign.ROCK);
        }
    };

    /**
     * Determines the result of confrontation between this sign and other sign
     *
     * @param sign the opposite sign
     * @return Result of sign confrontation
     */
    public Result against(Sign sign) {
        if (this.beats().contains(sign)) {
            return Result.WINS;
        } else if (this.beatenBy().contains(sign)) {
            return Result.LOSES;
        } else {
            return Result.DRAW;
        }
    }

    /**
     * @return the Set of signs that this sign can beat
     */
    public abstract Set<Sign> beats();

    /**
     * @return the Set of signs that this sign is beaten by
     */
    public abstract Set<Sign> beatenBy();

    private static Set<Sign> signSet(Sign... signs) {
        return new HashSet<>(Arrays.asList(signs));
    }

    public static final List<Sign> SIGNS = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = SIGNS.size();
}
