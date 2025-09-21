import java.util.Random;

public class Dice {
    private static volatile Dice instance;
    private final Random random;
    private int sides;

    private Dice() {
        this.random = new Random();
        this.sides = 6; // Default 6-sided dice
    }

    public static Dice getInstance() {
        if (instance == null) {
            synchronized (Dice.class) {
                if (instance == null) {
                    instance = new Dice();
                }
            }
        }
        return instance;
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        if (sides > 0) {
            this.sides = sides;
        }
    }
}
