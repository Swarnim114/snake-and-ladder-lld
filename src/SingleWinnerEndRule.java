import java.util.List;

public class SingleWinnerEndRule implements EndRule {
    private final WinRule winRule;

    public SingleWinnerEndRule() {
        this.winRule = new ExactWinRule(); // Default win rule
    }

    public SingleWinnerEndRule(WinRule winRule) {
        this.winRule = winRule;
    }

    @Override
    public boolean isGameOver(List<Player> players, Board board) {
        for (Player player : players) {
            if (winRule.hasWon(player, board)) {
                return true;
            }
        }
        return false;
    }
}