import java.util.List;

public class Board {
    private final int height;
    private final int width;
    private final List<BoardEntity> entities;

    public Board(int height, int width, List<BoardEntity> entities) {
        this.height = height;
        this.width = width;
        this.entities = entities;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void addEntity(BoardEntity entity) {
        this.entities.add(entity);
    }

    public void applyEffects(Player player) {
        for (BoardEntity entity : entities) {
            entity.applyEffect(player);
        }
    }

    public int coordinateToPosition(Coordinate coordinate) {
        // Convert 2D coordinate to 1D position (row-major order)
        return coordinate.getY() * width + coordinate.getX() + 1;
    }

    public Coordinate positionToCoordinate(int position) {
        // Convert 1D position to 2D coordinate (row-major order)
        int adjustedPos = position - 1; // Convert to 0-based
        int y = adjustedPos / width;
        int x = adjustedPos % width;
        return new Coordinate(x, y);
    }
}
