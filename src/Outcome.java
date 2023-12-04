/**
 * Represents the possible outcomes of a turn in the game.
 */
public enum Outcome {
    PLAYER1_WIN, PLAYER2_WIN, DRAW;

    /**
     * Determines the outcome of a turn based on the choices of the two players.
     *
     * @param player1Choice the choice made by player 1.
     * @param player2Choice the choice made by player 2.
     * @return the outcome of the turn based on the players' choices.
     * @throws AssertionError if an unknown choice is encountered.
     */
    public static Outcome determineOutcome(Choice player1Choice, Choice player2Choice) {
        if (player1Choice.equals(player2Choice)) {
            return Outcome.DRAW;
        }

        return switch (player1Choice) {
            case ROCK -> (player2Choice == Choice.SCISSORS) ? Outcome.PLAYER1_WIN : Outcome.PLAYER2_WIN;
            case PAPER -> (player2Choice == Choice.ROCK) ? Outcome.PLAYER1_WIN : Outcome.PLAYER2_WIN;
            case SCISSORS -> (player2Choice == Choice.PAPER) ? Outcome.PLAYER1_WIN : Outcome.PLAYER2_WIN;
            default -> throw new AssertionError("Unknown enum type: " + player1Choice);
        };
    }

    public String toString() {
        return switch (this) {
            case DRAW -> "Tasapeli!";
            case PLAYER1_WIN -> "Pelaaja 1 voittaa!";
            case PLAYER2_WIN -> "Pelaaja 2 voittaa!";
        };
    }
}
