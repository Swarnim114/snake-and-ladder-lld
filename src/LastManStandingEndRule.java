import java.util.List;

public class LastManStandingEndRule implements EndRule {
    private final WinRule winRule;

    public LastManStandingEndRule() {
        this.winRule = new ExactWinRule(); // Default win rule
    }

    public LastManStandingEndRule(WinRule winRule) {
        this.winRule = winRule;
    }

    @Override
    public boolean isGameOver(List<Player> players, Board board) {
        int winnersCount = 0;
        for (Player player : players) {
            if (winRule.hasWon(player, board)) {
                winnersCount++;
            }
        }
        // Game over when all but one player have won
        return winnersCount >= players.size() - 1;
    }
}