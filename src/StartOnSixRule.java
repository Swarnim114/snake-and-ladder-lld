public class StartOnSixRule implements StartRule {
    @Override
    public boolean canStart(int roll) {
        return roll == 6;
    }
}