public abstract class BoardEntity {
    private Coordinate start;
    private Coordinate end;

    public BoardEntity(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }

    abstract void applyEffect(Player player);

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getEnd() {
        return end;
    }
}
