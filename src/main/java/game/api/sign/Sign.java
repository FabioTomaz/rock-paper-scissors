package game.api.sign;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public Result against(Sign sign) {
        if (sign == beats()) {
            return Result.WINS;
        } else if (sign == beatenBy()) {
            return Result.LOSES;
        } else {
            return Result.DRAWS;
        }
    }

    public abstract Sign beats();

    public abstract Sign beatenBy();

    public static final List<Sign> SIGNS = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = SIGNS.size();
}
