public abstract class BoardEntity {
    private final Coordinate start;
    private final Coordinate end;

    public BoardEntity(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }

    public abstract void applyEffect(Player player);

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getEnd() {
        return end;
    }
}
