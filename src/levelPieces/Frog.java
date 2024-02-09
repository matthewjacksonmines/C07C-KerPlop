package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Frog extends GamePiece { // Frog moves only through interaction, thus, does not implement Moveable
	private int playerLastPos = -1;

    public Frog(int location) {
    	super('F', "Frog", location);
    }

    @Override
    public void draw() {
        System.out.print("F"); // Represent the Wall with a character
    }
    
    @Override
    public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
    	if (playerLastPos != -1) {
    		if (this.getLocation() == playerLocation) {
    			int newLocation;
            	if (playerLocation < playerLastPos) { // if player moves from right
            		newLocation = this.getLocation() + 1;
            	} else { // if player moves from left
                	newLocation = this.getLocation() - 1;
            	}
                // Check if the new location is valid (not out of bounds and not occupied)
                if (newLocation >= 0 && newLocation < gameBoard.length && gameBoard[newLocation] == null) {
                    // Move the knight to the new location
                    gameBoard[this.getLocation()] = null; // Clear the old location
                    this.setLocation(newLocation); // Update the location
                    gameBoard[newLocation] = this; // Place at new location
                }
    		
    		}
    	}
    	playerLastPos = playerLocation;
		return InteractionResult.ADVANCE;
    }
}
