import java.awt.Color;

import edu.macalester.graphics.*;


public class Food {

    //the actual food objects
    private Ellipse food;

    //how big our food that shows up will be
    private int radius;

    //color of food
    private Color color;

    //center of food
    private Point location;

    public Food (Point location) {
        color = Color.BLACK;
        this.location = location;
        radius = 3;
        makeFood();
    }

    /**
     * Makes the ellipse representing the food on the canvas with the given parameters
     * from above
     */
    private Ellipse makeFood() {
        food = new Ellipse(location.getX() - radius, location.getY() - radius, 
                                radius * 2, radius * 2);
        food.setFilled(true);
        food.setFillColor(color);
        food.setStrokeColor(color);
        return food;
    }

    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return location;
    }

    public void setCenter(Point newCenter) {
        this.location = newCenter;
    }

    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }


}