import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class GameTest {

    private Player player1;
    private Player player2;
    private Game game;

    @Before
    public void setUp() {
        player1 = Mockito.mock(Player.class);
        player2 = Mockito.mock(Player.class);
        game = new Game(3, player1, player2);
    }

    @Test
    public void testGameInitialization() {
        assertEquals(0, game.getTotalPlayedTurns());
        assertEquals(0, game.getAmountOfDraws());
        assertEquals(0, game.getAmountOfPlayer1Wins());
        assertEquals(0, game.getAmountOfPlayer2Wins());
        assertFalse(game.isFinished());
    }

    @Test
    public void testPlayTurnWithMockedChoices() {
        Mockito.when(player1.chooseNextMove()).thenReturn(Choice.ROCK);
        Mockito.when(player2.chooseNextMove()).thenReturn(Choice.SCISSORS);

        Turn turn = game.playTurn();
        assertEquals(Choice.ROCK, turn.getPlayer1Choice());
        assertEquals(Choice.SCISSORS, turn.getPlayer2Choice());
        assertEquals(Outcome.PLAYER1_WIN, turn.getOutcome());
        assertEquals(1, game.getAmountOfPlayer1Wins());
        assertEquals(1, game.getTotalPlayedTurns());
    }

    @Test
    public void testGameEndsAfterWins() {
        Mockito.when(player1.chooseNextMove()).thenReturn(Choice.ROCK);
        Mockito.when(player2.chooseNextMove()).thenReturn(Choice.SCISSORS);

        while (!game.isFinished()) {
            game.playTurn();
        }

        assertTrue(game.getAmountOfPlayer1Wins() >= 3 || game.getAmountOfPlayer2Wins() >= 3);
    }
}
