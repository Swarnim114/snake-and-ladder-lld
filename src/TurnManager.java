import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class TurnManager {
    private Queue<Player> playerQueue;

    public TurnManager(List<Player> players) {
        this.playerQueue = new LinkedList<>(players);
    }

    public Player nextPlayer() {
        Player currentPlayer = playerQueue.poll();
        if (currentPlayer != null) {
            playerQueue.offer(currentPlayer);
        }
        return currentPlayer;
    }
}