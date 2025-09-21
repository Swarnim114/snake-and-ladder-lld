import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumBoardSetup implements IBoardSetupStrategy {
    private final Random random;

    public MediumBoardSetup() {
        this.random = new Random();
    }

    @Override
    public List<BoardEntity> setupEntities(int height, int width, BoardEntityFactory factory) {
        List<BoardEntity> entities = new ArrayList<>();

        // Medium: Balanced snakes (6-8) and ladders (6-8)
        int numSnakes = 6 + random.nextInt(3); // 6-8 snakes
        int numLadders = 6 + random.nextInt(3); // 6-8 ladders

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
        // Generate snake: start higher, end lower
        int startPosition = 15 + random.nextInt(70); // Position 16-85
        int endPosition = 1 + random.nextInt(startPosition - 5); // At least 5 positions down

        Coordinate start = positionToCoordinate(startPosition, width);
        Coordinate end = positionToCoordinate(endPosition, width);

        return new Coordinate[] { start, end };
    }

    private Coordinate[] generateRandomLadderCoordinates(int height, int width) {
        // Generate ladder: start lower, end higher
        int startPosition = 2 + random.nextInt(75); // Position 3-77
        int endPosition = startPosition + 5 + random.nextInt(15); // At least 5 positions up

        if (endPosition > height * width - 1) {
            endPosition = height * width - 3;
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