import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game between two players, tracking the progress of turns played,
 * and determining the winner based on a set number of wins.
 */
public class Game {
    private final List<Turn> playedTurns;
    private final Player player1;
    private final Player player2;

    private final int winsToPlayUntil;

    /**
     * Constructs a Game with specified winning criteria and players.
     *
     * @param winsToPlayUntil the number of wins required for a player to win the game.
     * @param player1 the first player in the game.
     * @param player2 the second player in the game.
     */
    public Game(int winsToPlayUntil, Player player1, Player player2) {
        this.winsToPlayUntil = winsToPlayUntil;
        this.player1 = player1;
        this.player2 = player2;

        playedTurns = new ArrayList<>();
    }


    /**
     * Checks if the game has finished, which occurs when either player reaches the required wins.
     *
     * @return true if the game is finished, false otherwise.
     */
    public boolean isFinished() {
        return getAmountOfPlayer1Wins() >= winsToPlayUntil || getAmountOfPlayer2Wins() >= winsToPlayUntil;
    }

    /**
     * Updates the win count for the player who won the turn.
     *
     * @param outcome the outcome of the turn, determining which player won.
     */
    private void updateWinScores( Outcome outcome ) {
        switch (outcome) {
            case PLAYER1_WIN:
                player1.incrementWins();
                break;
            case PLAYER2_WIN:
                player2.incrementWins();
                break;
        }
    }

    /**
     * Executes a turn in the game where each player chooses their move, updates scores, and records the turn.
     *
     * @return the completed turn with the choices and outcome.
     */
    public Turn playTurn() {
        Choice player1Choice = player1.chooseNextMove();
        Choice player2Choice = player2.chooseNextMove();
        Turn turn = new Turn(player1Choice, player2Choice);
        updateWinScores(turn.getOutcome());
        playedTurns.add(turn);
        return turn;
    }


    public int getTotalPlayedTurns() {
        return playedTurns.size();
    }


    public int getAmountOfDraws() {
        return (int) playedTurns.stream().filter(t -> t.getOutcome().equals(Outcome.DRAW)).count();
    }

    public int getAmountOfPlayer1Wins() {
        return (int) playedTurns.stream().filter(t -> t.getOutcome().equals(Outcome.PLAYER1_WIN)).count();
    }

    public int getAmountOfPlayer2Wins() {
        return (int) playedTurns.stream().filter(t -> t.getOutcome().equals(Outcome.PLAYER2_WIN)).count();
    }

    public String toString() {
        int totalTurns = getTotalPlayedTurns();
        int draws = getAmountOfDraws();
        int player1Wins = getAmountOfPlayer1Wins();
        int player2Wins = getAmountOfPlayer2Wins();

        return String.format(
                """
                        Eriä pelattu: %d
                        Tasapelien lukumäärä: %d
                        Pelaaja 1:llä voittoja: %d
                        Pelaaja 2:llä voittoja: %d""",
                totalTurns, draws, player1Wins, player2Wins);
    }
}
