import java.awt.Color;

import edu.macalester.graphics.*;


public class Food extends Ellipse{
    //how big our food that shows up will be
    private static int radius = 8;

    //color of food
    private Color color;

    //center of food
    private Point location;

    public Food () {
        super(0 - radius, 0 - radius, 
        radius * 2, radius * 2);
        color = Color.BLACK;
        this.setFilled(true);
        this.setFillColor(color);
        this.setStrokeColor(color);
    }

    public int getRadius() {
        return radius;
    }

    public double getCenterX() {
        return location.getX();
    }
    public double getCenterY() {
        return location.getY();
    }

    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }


}