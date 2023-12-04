/**
 * Represents a player in a game of rock paper scissors
 */
public class Player {
    private int totalWins;
    public Player() {
        totalWins = 0;
    }

    /**
     * Selects the next move randomly.
     *
     * @return a string representing the selected move
     */
    public Choice chooseNextMove() {
        return Choice.getRandom();
    }

    /**
     * Increments the number of wins.
     */
    public void incrementWins() {
        totalWins++;
    }

    /**
     * Gets the total number of wins.
     *
     * @return the total number of wins
     */
    public int getTotalWins() {
        return totalWins;
    }
}
