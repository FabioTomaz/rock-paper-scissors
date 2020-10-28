package game.api.result;

public class DrawRoundResult implements RoundResult {
    @Override
    public String toString() {
        return "Draw";
    }

    @Override
    public int getScore() {
        return 0;
    }
}
