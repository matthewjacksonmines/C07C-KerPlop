package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class KnightPiece extends GamePiece implements Moveable {

    public KnightPiece(int location) {
    	super('K', "Knight", location); // Setup GamePiece as 'Knight' with symbol 'K'
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
        
        int newLocation = this.getLocation() + move;
        // Check if the new location is valid (not out of bounds and not occupied)
        if (newLocation >= 0 && newLocation < gameBoard.length && gameBoard[newLocation] == null) {
            // Move the knight to the new location
            gameBoard[this.getLocation()] = null; // Clear the old location
            this.setLocation(newLocation); // Update the knight's location
            gameBoard[newLocation] = this; // Place the knight at the new location
        }
    }
    
    @Override
    public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
    	if (this.getLocation() == playerLocation) {
    		System.out.println("You have been attacked by the evil knight! (-1 HP)");
            return InteractionResult.HIT; // attack the player
    	} else { 
    		return InteractionResult.NONE;
    	}
    }
}
