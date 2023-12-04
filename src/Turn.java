/**
 * Represents a single turn in the game, encapsulating both players' choices and the outcome of the turn.
 */
public class Turn {
    private final Outcome outcome;
    private final Choice player1Choice;
    private final Choice player2Choice;

    /**
     * Constructs a Turn with the given choices for each player.
     * The outcome of the turn is determined based on these choices.
     *
     * @param player1Choice the choice made by player 1.
     * @param player2Choice the choice made by player 2.
     */
    public Turn(Choice player1Choice, Choice player2Choice) {
        this.outcome = Outcome.determineOutcome(player1Choice, player2Choice);
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public Choice getPlayer1Choice() {
        return player1Choice;
    }
    public Choice getPlayer2Choice() {
        return player2Choice;
    }

    public String toString() {
        return String.format(
                """
                        Pelaaja 1 valinta: %s
                        Pelaaja 2 valinta: %s
                        %s""",
                getPlayer1Choice(), getPlayer2Choice(), getOutcome());
    }
}
