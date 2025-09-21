public class Snake extends BoardEntity {

    public Snake(Coordinate start, Coordinate end) {
        super(start, end);
        if (end.getY() >= start.getY()) {
            throw new IllegalArgumentException(
                    "A snake must go down. The end coordinate must be less than the start coordinate.");
        }
    }

    @Override
    public void applyEffect(Player player) {
        if (this.getStart().equals(player.getPosition())) {
            player.setPosition(getEnd());
        }
    }
}
