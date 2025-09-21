public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void move(int steps) {
        Coordinate currentPos = getPosition();

        int currentPosition = (currentPos.getY() * 10) + currentPos.getX() + 1;

        int newPosition = currentPosition + steps;

        if (newPosition > 100) {
            newPosition = 100; // Stay at final position if overshot
        }

        int newX = (newPosition - 1) % 10;
        int newY = (newPosition - 1) / 10;

        setPosition(new Coordinate(newX, newY));
    }
}
