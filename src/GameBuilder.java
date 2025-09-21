import java.util.List;
import java.util.ArrayList;

public class GameBuilder {
    private Board board;
    private final List<Player> players;
    private Dice dice;
    private TurnManager turnManager;
    private StartRule startRule;
    private WinRule winRule;
    private EndRule endRule;
    private int boardHeight = 10;
    private int boardWidth = 10;
    private Difficulty difficulty = Difficulty.EASY;

    public GameBuilder() {
        this.players = new ArrayList<>();
    }

    public GameBuilder setBoard(Board board) {
        this.board = board;
        return this;
    }

    public GameBuilder setBoardDimensions(int height, int width) {
        this.boardHeight = height;
        this.boardWidth = width;
        return this;
    }

    public GameBuilder setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public GameBuilder addPlayer(Player player) {
        this.players.add(player);
        return this;
    }

    public GameBuilder setDice(Dice dice) {
        this.dice = dice;
        return this;
    }

    public GameBuilder setTurnManager(TurnManager turnManager) {
        this.turnManager = turnManager;
        return this;
    }

    public GameBuilder setStartRule(StartRule startRule) {
        this.startRule = startRule;
        return this;
    }

    public GameBuilder setWinRule(WinRule winRule) {
        this.winRule = winRule;
        return this;
    }

    public GameBuilder setEndRule(EndRule endRule) {
        this.endRule = endRule;
        return this;
    }

    public Game build() {

        if (board == null) {
            BoardEntityFactory entityFactory = new DefaultBoardEntityFactory();
            IBoardSetupStrategy boardSetup = BoardSetupFactory.createBoardSetup(difficulty);
            List<BoardEntity> entities = boardSetup.setupEntities(boardHeight, boardWidth, entityFactory);
            board = new Board(boardHeight, boardWidth, entities);
        }

        if (turnManager == null && !players.isEmpty()) {
            turnManager = new TurnManager(players);
        }
        if (dice == null) {
            dice = Dice.getInstance();
        }

        return new Game(board, players, dice, turnManager, startRule, winRule, endRule);
    }
}