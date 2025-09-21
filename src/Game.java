import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private final TurnManager turnManager;
    private final StartRule startRule;
    private final WinRule winRule;
    private final EndRule endRule;

    public Game(Board board, List<Player> players, Dice dice, TurnManager turnManager,
            StartRule startRule, WinRule winRule, EndRule endRule) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.turnManager = turnManager;
        this.startRule = startRule;
        this.winRule = winRule;
        this.endRule = endRule;
    }

    public void start() {
        System.out.println("Starting Snake and Ladder Game!");

        while (!endRule.isGameOver(players, board)) {
            playTurn();
        }

        System.out.println("Game Over!");
        printWinners();
    }

    public void playTurn() {
        Player currentPlayer = turnManager.nextPlayer();
        int roll = dice.roll();

        System.out.println(currentPlayer.getName() + " rolled: " + roll);

        Coordinate currentPos = currentPlayer.getPosition();
        int currentPosition = board.coordinateToPosition(currentPos);

        if (currentPosition == 1 && !startRule.canStart(roll)) {
            System.out.println(currentPlayer.getName() + " can't start yet!");
        } else {
            Coordinate oldPosition = new Coordinate(currentPos.getX(), currentPos.getY());
            currentPlayer.move(roll);

            board.applyEffects(currentPlayer);

            Coordinate newPosition = currentPlayer.getPosition();
            int oldPos = board.coordinateToPosition(oldPosition);
            int newPos = board.coordinateToPosition(newPosition);

            System.out.println(currentPlayer.getName() + " moved from position " + oldPos + " to position " + newPos);

            if (winRule.hasWon(currentPlayer, board)) {
                System.out.println(currentPlayer.getName() + " has won!");
            }
        }
    }

    private void printWinners() {
        for (Player player : players) {
            if (winRule.hasWon(player, board)) {
                System.out.println("Winner: " + player.getName());
            }
        }
    }
}