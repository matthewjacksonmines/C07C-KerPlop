package levelPieces;

import gameEngine.Drawable;

public class WaterBottle implements Drawable {
    private int location;

    public WaterBottle(int location) {
        this.location = location;
    }

    @Override
    public void draw() {
        System.out.println("B"); // Represent the Bottle with a simple character for console-based display
    }
}
