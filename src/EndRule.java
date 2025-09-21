import java.util.List;

public interface EndRule {
    boolean isGameOver(List<Player> players, Board board);
}