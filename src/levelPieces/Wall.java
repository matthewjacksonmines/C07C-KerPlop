package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Wall extends GamePiece { // Shield piece cannot move, thus, does not implement Moveable
	private boolean isActive = true;

    public Wall(int location) {
    	super('W', "Wall", location);
    }

    @Override
    public void draw() {
        System.out.print("W"); // Represent the Wall with a character
    }
    
    @Override
    public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
    	if (isActive && this.getLocation() == playerLocation) {
            System.out.println("You destroyed a wall.");
            gameBoard[this.getLocation()] = null;
//            Attempts to remove the piece from the game. 
//            This is not possible many other ways given how the GameEngine and LevelSetup are coded.
            isActive = false; 
    	}
		return InteractionResult.NONE;
    }
}
