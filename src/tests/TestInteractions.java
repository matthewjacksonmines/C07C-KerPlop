package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import gameEngine.*;
import levelPieces.*;

public class TestInteractions {

    private Drawable[] gameBoard;
    private Player player;

    // Setup method to initialize the game board and place the player before each test
    @BeforeEach
    public void setUp() {
        gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        player = new Player(GameEngine.BOARD_SIZE / 2); // Placing the player in the middle of the game board
    }

    // Test the interaction between the player and the Frog piece
    @Test
    public void testFrogInteraction() {
        Frog frog = new Frog(player.getLocation());
        gameBoard[player.getLocation()] = frog;
        InteractionResult result = frog.interact(gameBoard, player.getLocation());
        assertEquals(InteractionResult.ADVANCE, result, "Interaction with Frog should result in ADVANCE");
    }

    // Test that there is no interaction when the KnightPiece is on a different square than the player
    @Test
    public void testKnightPieceInteractionDifferentSquare() {
        KnightPiece knight = new KnightPiece(player.getLocation() + 1); // Knight is placed next to the player
        gameBoard[player.getLocation() + 1] = knight;
        InteractionResult result = knight.interact(gameBoard, player.getLocation());
        assertEquals(InteractionResult.NONE, result, "Knight should not interact with the player when on different squares.");
    }

    // Test the interaction between the player and the KnightPiece when on the same square
    @Test
    public void testKnightPieceInteractionSameSquare() {
        KnightPiece knight = new KnightPiece(player.getLocation()); // Knight is placed on the same square as the player
        gameBoard[player.getLocation()] = knight;
        InteractionResult result = knight.interact(gameBoard, player.getLocation());
        assertEquals(InteractionResult.HIT, result, "Knight should hit the player when on the same square.");
    }

    // Test the interaction with a Wall, which should always result in no interaction
    @Test
    public void testWallInteraction() {
        Wall wall = new Wall(player.getLocation() + 1); // Wall is placed next to the player
        gameBoard[player.getLocation() + 1] = wall;
        InteractionResult result = wall.interact(gameBoard, player.getLocation());
        assertEquals(InteractionResult.NONE, result, "Interaction with Wall should result in NONE");
    }
    
    // Test that the SuspiciousStatue kills the player when they share the same square
    @Test
    public void testSuspiciousStatueKillsPlayerOnSameSquare() {
        SuspiciousStatue suspiciousStatue = new SuspiciousStatue(5);
        gameBoard[5] = suspiciousStatue;
        InteractionResult result = suspiciousStatue.interact(gameBoard, 5);
        assertEquals(InteractionResult.KILL, result, "SuspiciousStatue should kill the player on the same square.");
    }

    // Test that there is no interaction when the SuspiciousStatue and the player are on different squares
    @Test
    public void testSuspiciousStatueNoInteractionOnDifferentSquare() {
        SuspiciousStatue suspiciousStatue = new SuspiciousStatue(5);
        gameBoard[5] = suspiciousStatue;
        InteractionResult result = suspiciousStatue.interact(gameBoard, 4);
        assertEquals(InteractionResult.NONE, result, "SuspiciousStatue should not interact with the player on a different square.");
    }

    // Test the interaction with a Statue, which should give a point to the player
    @Test
    public void testStatueGivesPointOnInteraction() {
        Statue statue = new Statue(5);
        gameBoard[5] = statue;
        InteractionResult result = statue.interact(gameBoard, 5);
        assertEquals(InteractionResult.GET_POINT, result, "Statue should give a point when interacted with by the player.");
    }

    // Test that the Statue does not interact after the first interaction
    @Test
    public void testStatueNoInteractionAfterFirst() {
        Statue statue = new Statue(5);
        gameBoard[5] = statue;
        statue.interact(gameBoard, 5); // First interaction deactivates the statue
        InteractionResult result = statue.interact(gameBoard, 5); // Testing interaction after the statue is deactivated
        assertEquals(InteractionResult.NONE, result, "Statue should not interact after the first interaction.");
    }
}
