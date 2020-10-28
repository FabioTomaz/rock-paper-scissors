package game.api.sign;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for sign related logic
 */
public class SignTest {

    @Test
    public void checkRockBeatsScissor() {
        Assert.assertEquals(Result.WINS, Sign.ROCK.against(Sign.SCISSORS));
    }

    @Test
    public void checkPaperBeatsRock() {
        Assert.assertEquals(Result.WINS, Sign.PAPER.against(Sign.ROCK));
    }

    @Test
    public void checkScissorBeatsPaper() {
        Assert.assertEquals(Result.WINS, Sign.SCISSORS.against(Sign.PAPER));
    }

    @Test
    public void checkRockIsBeatenByPaper() {
        Assert.assertEquals(Result.LOSES, Sign.ROCK.against(Sign.PAPER));
    }

    @Test
    public void checkPaperIsBeatenByScissor() {
        Assert.assertEquals(Result.LOSES, Sign.PAPER.against(Sign.SCISSORS));
    }

    @Test
    public void checkScissorIsBeatenByRock() {
        Assert.assertEquals(Result.LOSES, Sign.SCISSORS.against(Sign.ROCK));
    }

    @Test
    public void checkRockDrawsRock() {
        Assert.assertEquals(Result.DRAWS, Sign.ROCK.against(Sign.ROCK));
    }

    @Test
    public void checkPaperDrawsPaper() {
        Assert.assertEquals(Result.DRAWS, Sign.PAPER.against(Sign.PAPER));
    }

    @Test
    public void checkScissorDrawsScissor() {
        Assert.assertEquals(Result.DRAWS, Sign.SCISSORS.against(Sign.SCISSORS));
    }
}
