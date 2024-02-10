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
    
    
    // Replace with needed move tests
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
