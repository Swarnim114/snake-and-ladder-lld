public class Ladder extends BoardEntity {

    public Ladder(Coordinate start, Coordinate end) {
        super(start, end);
        if (start.getY() >= end.getY()) {
            throw new IllegalArgumentException(
                    "A ladder must go up. The start coordinate must be less than the end coordinate.");
        }
    }

    @Override
    void applyEffect(Player player) {
        if (this.getStart() == player.getPosition()) {
            player.setPosition(getEnd());
        }
    }
}