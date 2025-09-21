public class App {
    public static void main(String[] args) {
        // Create and start game using GameBuilder
        Game game = new GameBuilder()
                .setBoardDimensions(10, 10)
                .setDifficulty(Difficulty.EASY)
                .addPlayer(new HumanPlayer("Alice"))
                .addPlayer(new HumanPlayer("Bob"))
                .setStartRule(new StartAnywhereRule())
                .setWinRule(new ExactWinRule())
                .setEndRule(new SingleWinnerEndRule())
                .build();

        game.start();
    }
}