package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import java.util.ArrayList;

public class LevelSetup {
    private Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    private ArrayList<Moveable> movingPieces = new ArrayList<>();
    private ArrayList<GamePiece> interactingPieces = new ArrayList<>();
    private int playerStartLoc;

    public LevelSetup() {
        // Constructor can initialize any necessary data or configurations
    }

    // Method to create and configure a level based on the level number
    public void createLevel(int levelNum) {
        clearLevel(); // Prepare for new level setup
        switch (levelNum) {
            case 1:
                setupLevel1();
                break;
            case 2:
                setupLevel2();
                break;
            // Additional levels can be added here
        }
    }

    // Setup methods for each level
    private void setupLevel1() {
        // Example setup for level 1
        // This should include initializing game pieces, placing them on the game board,
        // and determining player's starting location.
        // Remember to add pieces to movingPieces and interactingPieces as appropriate.
    	playerStartLoc = 6;
    	
    	WaterBottle bottle = new WaterBottle(0);
    	gameBoard[0] = bottle;
    	
    	KnightPiece knight1 = new KnightPiece(1);
    	gameBoard[1] = knight1;
    	movingPieces.add(knight1);
    	interactingPieces.add(knight1);
    	
    	KnightPiece knight2 = new KnightPiece(2);
    	gameBoard[2] = knight2;
    	movingPieces.add(knight2);
    	interactingPieces.add(knight2);
    	
    	Statue regStat1 = new Statue(12);
    	gameBoard[12] = regStat1;
    	interactingPieces.add(regStat1);
    	
    	SuspiciousStatue susStat = new SuspiciousStatue(15);
    	gameBoard[15] = susStat;
    	movingPieces.add(susStat);
    	interactingPieces.add(susStat);
    	
    	Statue regStat2 = new Statue(18);
    	gameBoard[18] = regStat2;
    	interactingPieces.add(regStat2);
    	
    }

    private void setupLevel2() {
        // Setup for level 2
    }

    // Utility method to clear the game board and reset piece lists
    private void clearLevel() {
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = null;
        }
        movingPieces.clear();
        interactingPieces.clear();
    }

    // Getters for the game engine to access the configured level data
    public Drawable[] getBoard() {
        return gameBoard;
    }

    public ArrayList<Moveable> getMovingPieces() {
        return movingPieces;
    }

    public ArrayList<GamePiece> getInteractingPieces() {
        return interactingPieces;
    }

    public int getPlayerStartLoc() {
        return playerStartLoc;
    }

    // Additional methods to setup each level specifics...
}
