import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HardBoardSetup implements IBoardSetupStrategy {
    private final Random random;

    public HardBoardSetup() {
        this.random = new Random();
    }

    @Override
    public List<BoardEntity> setupEntities(int height, int width, BoardEntityFactory factory) {
        List<BoardEntity> entities = new ArrayList<>();

        // Hard: More snakes (8-12), less ladders (3-5)
        int numSnakes = 8 + random.nextInt(5); // 8-12 snakes
        int numLadders = 3 + random.nextInt(3); // 3-5 ladders

        // Create snakes
        for (int i = 0; i < numSnakes; i++) {
            Coordinate[] snakeCoords = generateRandomSnakeCoordinates(height, width);
            entities.add(factory.createSnake(snakeCoords[0], snakeCoords[1]));
        }

        // Create ladders
        for (int i = 0; i < numLadders; i++) {
            Coordinate[] ladderCoords = generateRandomLadderCoordinates(height, width);
            entities.add(factory.createLadder(ladderCoords[0], ladderCoords[1]));
        }

        return entities;
    }

    private Coordinate[] generateRandomSnakeCoordinates(int height, int width) {
        // Generate snake: start higher, end lower (more aggressive snakes)
        int startPosition = 10 + random.nextInt(80); // Position 11-90 (wider range)
        int endPosition = 1 + random.nextInt(startPosition - 2); // At least 2 positions down

        Coordinate start = positionToCoordinate(startPosition, width);
        Coordinate end = positionToCoordinate(endPosition, width);

        return new Coordinate[] { start, end };
    }

    private Coordinate[] generateRandomLadderCoordinates(int height, int width) {
        // Generate ladder: start lower, end higher (fewer, shorter ladders)
        int startPosition = 2 + random.nextInt(60); // Position 3-62 (smaller range)
        int endPosition = startPosition + 3 + random.nextInt(10); // Shorter ladders (3-12 positions)

        if (endPosition > height * width - 1) {
            endPosition = height * width - 2;
        }

        Coordinate start = positionToCoordinate(startPosition, width);
        Coordinate end = positionToCoordinate(endPosition, width);

        return new Coordinate[] { start, end };
    }

    private Coordinate positionToCoordinate(int position, int width) {
        int adjustedPos = position - 1; // Convert to 0-based
        int y = adjustedPos / width;
        int x = adjustedPos % width;
        return new Coordinate(x, y);
    }
}