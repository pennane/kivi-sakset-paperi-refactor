import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testChooseNextMove() {
        assertNotNull(player.chooseNextMove());
        assertTrue(player.chooseNextMove() instanceof Choice);
    }

    @Test
    public void testIncrementAndGetTotalWins() {
        assertEquals(0, player.getTotalWins());

        player.incrementWins();
        assertEquals(1, player.getTotalWins());

        player.incrementWins();
        assertEquals(2, player.getTotalWins());
    }
}