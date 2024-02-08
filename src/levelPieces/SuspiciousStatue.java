package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class SuspiciousStatue extends GamePiece implements Moveable {
    private int playerLastPos = -1;

    public SuspiciousStatue(int location) {
    	super('S', "Suspicious Statue", location);
    }

    @Override
    public void draw() {
        System.out.print("S"); // Represent the Statue with a character
    }
    
    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        if (playerLastPos != -1) {
        	int newLocation;
        	if (playerLocation < playerLastPos && this.getLocation() > playerLocation) {
        		newLocation = this.getLocation() - 2;
        	} else if (playerLocation > playerLastPos && this.getLocation() < playerLocation) {
            	newLocation = this.getLocation() + 2;
        	} else {
        		newLocation = this.getLocation();
        	}
            // Check if the new location is valid (not out of bounds and not occupied)
            if (newLocation >= 0 && newLocation < gameBoard.length && gameBoard[newLocation] == null) {
                // Move the knight to the new location
                gameBoard[this.getLocation()] = null; // Clear the old location
                this.setLocation(newLocation); // Update the location
                gameBoard[newLocation] = this; // Place at new location
            }
        }
    	playerLastPos = playerLocation;
    }
    
    @Override
    public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
    	if (this.getLocation() == playerLocation) {
    		System.out.println("You have been instantly killed from behind by the statue that only moves when you move away from it! Oh no!");
            return InteractionResult.KILL; // Kill the player
    	} else {
    		return InteractionResult.NONE;
    	}
    }
}
