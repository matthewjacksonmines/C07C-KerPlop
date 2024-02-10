package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import gameEngine.*;
import levelPieces.*;

import org.junit.jupiter.api.Test;

class TestMovingPieces {
	
	private Drawable[] gameBoard;
    private Player player;
    
	// Setup method to initialize the game board and place the player before each test
    @BeforeEach
    public void setUp() {
        gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        player = new Player(GameEngine.BOARD_SIZE / 2); // Placing the player in the middle of the game board
    }
    
	
	// Test the movement to ensure that the knight can and only can move in directions -1, 0 and 1
    @Test
    public void testKnightPieceRandomMovement() {
        KnightPiece knight = new KnightPiece(player.getLocation()); // Knight is placed on the same square as the player
        int initialPos = player.getLocation() + 2 ;
        
//        Note that the random nature of this pieces movement requires a number of test runs to see if a desirable result is achievable
        boolean outcomeAchieved = false;
        int moveDelta = 0;
//        Tests for moves -1,0, and 1
        for (int moveDir = -1; moveDir <= 1; moveDir++) {
        	// for each possible move, test MAX of 1000 times to see if the knight is able to move in that direction
        	for (int i = 0; i < 1000 && !outcomeAchieved; i++) {
                gameBoard[initialPos] = knight;
                knight.move(gameBoard, player.getLocation());
                moveDelta = knight.getLocation() - initialPos;
                if (moveDelta == moveDir) {
                	outcomeAchieved = true;
                }
                assertTrue(moveDelta >= -1 && moveDelta <= 1, "Knight should only be able to move 1 space in either direction. Not " + moveDelta + " spaces.");
            }
            assertTrue(outcomeAchieved, "Knight was unable to move " + moveDir + " spaces in 1000 attempts.");
            outcomeAchieved = false;
        }
    }
    
    // test the Suspicious Statue to ensure that the first move, before the players position is record DOES NOT MOVE THE PIECE
    @Test
    public void testSuspiciousStatuePieceNoMoveFirstTurn() {
    	SuspiciousStatue statue = new SuspiciousStatue(player.getLocation() + 1);
    	gameBoard[player.getLocation() + 1] = statue;
    	int oldPos = statue.getLocation();
    	statue.move(gameBoard, player.getLocation());
    	assertEquals(statue.getLocation(), oldPos, "Suspicious statue is not supposed to move before it knows the players previous position.");
    }
    
    // test the Suspicious Statue to make sure it does not move if the player is in the way
    @Test
    public void testSuspiciousStatuePieceNoMoveBlockedByPlayer() {
    	SuspiciousStatue statue = new SuspiciousStatue(player.getLocation() + 1);
    	gameBoard[player.getLocation() + 1] = statue;
    	int oldPos = statue.getLocation();
    	statue.move(gameBoard, player.getLocation()); // record the current player's position.
    	statue.move(gameBoard, player.getLocation() - 1); // attempt to chase the player (to the left), but the player is in the way
    	assertEquals(statue.getLocation(), oldPos, "Suspicious statue is not supposed to move when player is in the way.");
    }
    
 // test the Suspicious Statue to make sure it does not move if the player is in the way
    @Test
    public void testSuspiciousStatuePieceNoMoveBlockedByPiece() {
    	SuspiciousStatue statue = new SuspiciousStatue(player.getLocation() + 3);
    	gameBoard[player.getLocation() + 3] = statue;
    	int oldPos = statue.getLocation();
    	statue.move(gameBoard, player.getLocation()); // record the current player's position.
    	
    	Wall wall = new Wall(player.getLocation() + 1); // place wall in path of statue
    	gameBoard[player.getLocation() + 1] = wall;
    	
    	statue.move(gameBoard, player.getLocation() - 1); // attempt to chase the player (to the left), but a wall is in the way
    	assertEquals(statue.getLocation(), oldPos, "Suspicious statue is not supposed to move when wall is in the way.");
    }
    
    @Test
    public void testSuspiciousStatuePieceMoveLeft() {
    	SuspiciousStatue statue = new SuspiciousStatue(player.getLocation() + 3);
    	gameBoard[player.getLocation() + 3] = statue;
    	int oldPos = statue.getLocation();
    	statue.move(gameBoard, player.getLocation()); // record the current player's position.
    	
    	statue.move(gameBoard, player.getLocation() - 1); // attempt to chase the player (to the left)
    	assertEquals(statue.getLocation(), oldPos - 2, "Suspicious statue is supposed to move towards the player when the player moves away from it to the left.");
    }
    
    @Test
    public void testSuspiciousStatuePieceMoveRight() {
    	SuspiciousStatue statue = new SuspiciousStatue(player.getLocation() - 3);
    	gameBoard[player.getLocation() - 3] = statue;
    	int oldPos = statue.getLocation();
    	statue.move(gameBoard, player.getLocation()); // record the current player's position.
    	
    	statue.move(gameBoard, player.getLocation() + 1); // attempt to chase the player (to the right)
    	assertEquals(statue.getLocation(), oldPos + 2, "Suspicious statue is supposed to move towards the player when the player moves away from it to the right.");
    }
    
    @Test
    public void testSuspiciousStatuePieceNoMoveApproachFromLeft() {
    	SuspiciousStatue statue = new SuspiciousStatue(player.getLocation() + 4);
    	gameBoard[player.getLocation() + 4] = statue;
    	int oldPos = statue.getLocation();
    	statue.move(gameBoard, player.getLocation()); // record the current player's position.
    	
    	statue.move(gameBoard, player.getLocation() + 1); // attempt to chase the player (from left, to the right)
    	assertEquals(statue.getLocation(), oldPos, "Suspicious statue is supposed to move towards the player when the player approaches the statue (from left).");
    }
    
    @Test
    public void testSuspiciousStatuePieceNoMoveApproachFromRight() {
    	SuspiciousStatue statue = new SuspiciousStatue(player.getLocation() - 4);
    	gameBoard[player.getLocation() - 4] = statue;
    	int oldPos = statue.getLocation();
    	statue.move(gameBoard, player.getLocation()); // record the current player's position.
    	
    	statue.move(gameBoard, player.getLocation() - 1); // attempt to chase the player (from right, to the left)
    	assertEquals(statue.getLocation(), oldPos, "Suspicious statue is supposed to move towards the player when the player approaches the statue (from right).");
    }
}
