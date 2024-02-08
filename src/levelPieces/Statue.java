package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Statue extends GamePiece implements Drawable {
	
	private boolean isActive = true;

    public Statue(int location) {
    	super('S', "Normal Statue", location); // Setup statue as Normal Statue with character representation: 'S'
    }

    @Override
    public void draw() {
        System.out.print("S"); // Represent the Statue with a character
    }

    public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
    	if (isActive && this.getLocation() == playerLocation) {
            System.out.println("You've encountered a Statue. It doesn't move, but it's quite majestic. (+1 point)");
            gameBoard[this.getLocation()] = null;
//            Attempts to remove the piece from the game. 
//            This is not possible many other ways given how the GameEngine and LevelSetup are coded.
            isActive = false; 
            return InteractionResult.GET_POINT; // Example of interaction result
    	} else {
    		return InteractionResult.NONE;
    	}
    	
    }
}
