package levelPieces;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class KnightPiece implements Drawable, Moveable {
    private int location; // The knight's current position on the game board
    private final char symbol = 'K'; // Symbol for drawing the knight

    public KnightPiece(int location) {
        this.location = location;
    }

    @Override
    public void draw() {
        System.out.print(symbol);
    }

    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        // Example movement logic considering the game board and player's location

        // Determine movement direction or strategy here
        // For simplicity, let's make a random move that doesn't consider the game board or player location
        int move = (int) (Math.random() * 3) - 1; // Randomly chooses -1, 0, or 1
        
        int newLocation = this.location + move;
        // Check if the new location is valid (not out of bounds and not occupied)
        if (newLocation >= 0 && newLocation < gameBoard.length && gameBoard[newLocation] == null) {
            // Move the knight to the new location
            gameBoard[this.location] = null; // Clear the old location
            this.location = newLocation; // Update the knight's location
            gameBoard[newLocation] = this; // Place the knight at the new location
        }
        // Additional logic could be implemented to handle interactions or more sophisticated movement
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
