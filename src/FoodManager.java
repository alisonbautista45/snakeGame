import java.util.Random;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public class FoodManager {

    private CanvasWindow canvas;

    public Food food;

    private Point location;

    private Point check1;
    private Point check2;
    private Point check3;
    private Point check4;

    private GraphicsGroup group;

    private int x;
    private int y;

    FoodManager(CanvasWindow canvas, GraphicsGroup group) {
        x = new Random().nextInt(canvas.getWidth());
        y = new Random().nextInt(canvas.getHeight());
        location = new Point(x, y);
        food = new Food(location);
        this.canvas = canvas;
        this.group = group;
        addFood();
    }

    /**
     * If the piece of food is eaten (isEaten), then the food dissapears and is added
     * to a new spot on the canvas.
     */
     public void foodEaten(boolean isEaten) {
        if (isEaten) {
            addFood();
        }
     }

    /**
     * Removes piece of food from canvas
     */

    /**
     * Adds piece of food to the canvas
     */
    public void addFood() {
        food = new Food(location);
        newLocation();
        group.add(food);
    }

    /** 
     * Sets the piece of food to a new random spot on the canvas. Will have to add
     * ability to see where snake is and not place food there.
     */
    public void newLocation() {
        x = new Random().nextInt(canvas.getWidth());
        y = new Random().nextInt(canvas.getHeight());
        location = new Point(x, y);
        check1 = new Point(x + food.getRadius(), y + food.getRadius());
        check2 = new Point(x + food.getRadius(), y - food.getRadius());
        check3 = new Point(x - food.getRadius(), y + food.getRadius());
        check4 = new Point(x - food.getRadius(), y - food.getRadius());
        while(canvas.getElementAt(check1) != null || 
                canvas.getElementAt(check2) != null || 
                canvas.getElementAt(check3) != null || 
                canvas.getElementAt(check4) != null ||
                x - food.getRadius() < 0 || x + food.getRadius() > canvas.getWidth() ||
                y - food.getRadius() < 0 || y + food.getRadius() > canvas.getHeight()) {
            x = new Random().nextInt(canvas.getWidth());
            y = new Random().nextInt(canvas.getHeight());
            location = new Point(x, y);
            check1 = new Point(x + food.getRadius(), y + food.getRadius());
            check2 = new Point(x + food.getRadius(), y - food.getRadius());
            check3 = new Point(x - food.getRadius(), y + food.getRadius());
            check4 = new Point(x - food.getRadius(), y - food.getRadius());
        }
        food.setCenter(location);
    }

}
