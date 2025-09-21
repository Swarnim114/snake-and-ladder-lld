public class OvershootWinRule implements WinRule {
    @Override
    public boolean hasWon(Player player, Board board) {
        int totalSquares = board.getHeight() * board.getWidth();
        int playerPosition = board.coordinateToPosition(player.getPosition());
        return playerPosition >= totalSquares;
    }
}