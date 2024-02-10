package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class LaserPiece extends GamePiece { // Laser piece cannot move, thus, does not implement Moveable

    public LaserPiece(int location) {
    	super('L', "Laser Turret", location);
    }

    @Override
    public void draw() {
        System.out.print("L"); // Represent the Laser with a character
    }
    
    @Override
    public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
    	// check left side of the statue
        for (int i = this.getLocation() - 1; i >= 0; i--) {
        	if (i == playerLocation) {
                System.out.println("You have been laser'd to death! Oh no!");
                return InteractionResult.KILL; // Kill the player
            }
            if (gameBoard[i] != null) {
                // found the first non-null object
                break; // break the loop if a non-null object is found (excluding the player)
            }
        }
        
     // check right side of the statue
        for (int i = this.getLocation() + 1; i < gameBoard.length; i++) {
        	if (i == playerLocation) {
                System.out.println("You have been laser'd to death! Oh no!");
                return InteractionResult.KILL; // Kill the player
            }
            if (gameBoard[i] != null) {
                // found the first non-null object
                break; // break the loop if a non-null object is found (excluding the player)
            }
        }
        return InteractionResult.NONE; // do nothing if player not in line of sight
    }
}
