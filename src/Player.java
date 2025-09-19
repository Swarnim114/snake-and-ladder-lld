public abstract class Player {
    private String name;
    private Coordinate position;

    public abstract String getName();

    public abstract Coordinate getPosition();

    public abstract void setPosition(Coordinate cr);
}
