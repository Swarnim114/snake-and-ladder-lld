public class DefaultBoardEntityFactory implements BoardEntityFactory {

    @Override
    public Snake createSnake(Coordinate start, Coordinate end) {
        return new Snake(start, end);
    }

    @Override
    public Ladder createLadder(Coordinate start, Coordinate end) {
        return new Ladder(start, end);
    }
}