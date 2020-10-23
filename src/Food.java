import java.awt.Color;

import edu.macalester.graphics.*;


public class Food extends Ellipse{

    //how big our food that shows up will be
    private static int radius = 8;

    public Food() {
        super(0 - radius, 0 - radius, 
        radius * 2, radius * 2);
        this.setFilled(true);
        this.setFillColor(SnakeGame.RED);
        this.setStrokeColor(Color.BLACK);
    }

    public int getRadius() {
        return radius;
    }
}