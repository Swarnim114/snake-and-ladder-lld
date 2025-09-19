public class HumanPlayer extends Player {
    private String name;
    private Coordinate position;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Coordinate getPosition() {
        return position;
    }

    @Override
    public void setPosition(Coordinate position) {
        this.position = position;
    }

}
