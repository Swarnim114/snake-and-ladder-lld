public class BoardSetupFactory {

    public static IBoardSetupStrategy createBoardSetup(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return new EasyBoardSetup();
            case MEDIUM:
                return new MediumBoardSetup();
            case HARD:
                return new HardBoardSetup();
            default:
                return new EasyBoardSetup(); // Default fallback
        }
    }
}