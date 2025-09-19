import java.util.List;

public class Board {
    private int height;
    private int weight;

    private List<BoardEntity> entities;

    public Board(int height, int weight, List<BoardEntity> entities) {
        this.height = height;
        this.weight = weight;
        this.entities = entities;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void addEntity(BoardEntity entity) {
        this.entities.add(entity);
    }

}
