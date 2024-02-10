package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import gameEngine.*;
import levelPieces.*;

public class TestInteractions {

    private Drawable[] gameBoard;
    private Player player;

    @BeforeEach
    public void setUp() {
        gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        player = new Player(GameEngine.BOARD_SIZE / 2);
    }

    @Test
    public void testFrogInteraction() {
        Frog frog = new Frog(player.getLocation());
        gameBoard[player.getLocation()] = frog;
        InteractionResult result = frog.interact(gameBoard, player.getLocation());
        assertEquals(InteractionResult.ADVANCE, result, "Interaction with Frog should result in ADVANCE");
    }

    @Test
    public void testKnightPieceInteractionDifferentSquare() {
        KnightPiece knight = new KnightPiece(player.getLocation() + 1); // Knight not on the same square as player
        gameBoard[player.getLocation() + 1] = knight;
        // Simulate interaction where player and knight are not on the same square
        InteractionResult result = knight.interact(gameBoard, player.getLocation());
        assertEquals(InteractionResult.NONE, result, "Knight should not interact with the player when on different squares.");
    }

    @Test
    public void testKnightPieceInteractionSameSquare() {
        KnightPiece knight = new KnightPiece(player.getLocation()); // Knight on the same square as player
        gameBoard[player.getLocation()] = knight;
        InteractionResult result = knight.interact(gameBoard, player.getLocation());
        assertEquals(InteractionResult.HIT, result, "Knight should hit the player when on the same square.");
    }
   

    @Test
    public void testWallInteraction() {
        Wall wall = new Wall(player.getLocation() + 1);
        gameBoard[player.getLocation() + 1] = wall;
        InteractionResult result = wall.interact(gameBoard, player.getLocation());
        assertEquals(InteractionResult.NONE, result, "Interaction with Wall should result in NONE");
    }
}
