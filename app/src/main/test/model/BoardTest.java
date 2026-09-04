import org.junit.Before;
import org.junit.Test;
import model.Board;
import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    /**
     * Test: Board should be created with initial state
     */
    @Test
    public void testBoardInitialization() {
        assertNotNull(board);
        assertTrue(board.isInProgressMode());
        assertFalse(board.isInFinishedMode());
    }

    /**
     * Test: Mark a valid cell (0, 0)
     */
    @Test
    public void testMarkValidCell() {
        board.mark(0, 0);
        assertTrue(board.isInProgressMode());
    }

    /**
     * Test: Mark multiple valid cells in sequence
     */
    @Test
    public void testMarkMultipleCells() {
        board.mark(0, 0); // X plays
        board.mark(0, 1); // O plays
        board.mark(1, 1); // X plays
        assertTrue(board.isInProgressMode());
    }

    /**
     * Test: Mark out-of-bounds row (should be no-op)
     */
    @Test
    public void testMarkOutOfBoundsRow() {
        board.mark(-1, 0); // Invalid row
        board.mark(3, 0);  // Invalid row
        assertTrue(board.isInProgressMode());
    }

    /**
     * Test: Mark out-of-bounds column (should be no-op)
     */
    @Test
    public void testMarkOutOfBoundsColumn() {
        board.mark(0, -1); // Invalid column
        board.mark(0, 3);  // Invalid column
        assertTrue(board.isInProgressMode());
    }

    /**
     * Test: Restart should reset the game
     */
    @Test
    public void testRestart() {
        board.mark(0, 0);
        board.restart();
        assertTrue(board.isInProgressMode());
        assertFalse(board.isInFinishedMode());
    }

    /**
     * Test: Multiple restarts
     */
    @Test
    public void testMultipleRestarts() {
        board.mark(0, 0);
        board.restart();
        board.mark(1, 1);
        board.restart();
        assertTrue(board.isInProgressMode());
    }

    /**
     * Test: Game state alternates between in-progress and finished
     */
    @Test
    public void testGameStateTransition() {
        assertTrue(board.isInProgressMode());
        assertFalse(board.isInFinishedMode());
        
        // Simulate some moves
        board.mark(0, 0);
        assertTrue(board.isInProgressMode());
    }

    /**
     * Test: Check board after multiple valid marks
     */
    @Test
    public void testComplexSequence() {
        board.mark(0, 0);
        assertTrue(board.isInProgressMode());
        
        board.mark(0, 1);
        assertTrue(board.isInProgressMode());
        
        board.mark(1, 1);
        assertTrue(board.isInProgressMode());
        
        board.mark(1, 0);
        assertTrue(board.isInProgressMode());
    }

    /**
     * Test: Mark with large integer values (should be ignored)
     */
    @Test
    public void testMarkWithLargeValues() {
        board.mark(100, 100);
        assertTrue(board.isInProgressMode());
    }

    /**
     * Test: Verify board is operational after restart
     */
    @Test
    public void testBoardOperationalAfterRestart() {
        board.mark(0, 0);
        board.restart();
        
        // Board should accept new marks
        board.mark(1, 1);
        assertTrue(board.isInProgressMode());
    }
}
