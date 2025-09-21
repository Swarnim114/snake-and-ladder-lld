public abstract class Player {
    private final String name;
    private Coordinate position;

    public Player(String name) {
        this.name = name;
        this.position = new Coordinate(0, 0); // Starting position (0,0) = position 1
    }

    public abstract void move(int steps);

    public Coordinate getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }
}
