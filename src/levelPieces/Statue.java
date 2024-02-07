package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Statue implements Drawable {
    private int location;

    public Statue(int location) {
        this.location = location;
    }

    @Override
    public void draw() {
        System.out.println("S"); // Represent the Statue with a character
    }

    public InteractionResult interact() {
        System.out.println("You've encountered a Statue. It doesn't move, but it's quite majestic.");
        return InteractionResult.GET_POINT; // Example of interaction result
    }
}
