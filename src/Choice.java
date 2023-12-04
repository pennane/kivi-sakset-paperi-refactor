import java.util.Random;

/**
 * Represents the possible choices a player can make in a game of rock paper scissors.
 */
public enum Choice {
    ROCK, PAPER, SCISSORS;

    private static final Random RANDOM = new Random();

    /**
     * Selects a random choice from the available options.
     *
     * @return a randomly selected {@link Choice}.
     */
    public static Choice getRandom() {
        Choice[] values = Choice.values();
        return values[RANDOM.nextInt(values.length)];
    }

    public String toString() {
        return switch (this) {
            case ROCK -> "Kivi";
            case PAPER -> "Paperi";
            case SCISSORS -> "Sakset";
        };
    }
}
