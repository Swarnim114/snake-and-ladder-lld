public interface BoardEntityFactory {
    Snake createSnake(Coordinate start, Coordinate end);

    Ladder createLadder(Coordinate start, Coordinate end);
}