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
