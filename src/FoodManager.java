import java.util.Random;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

public class FoodManager {

    private CanvasWindow canvas;

    public Food food;

    private Point location;

    private int x;
    private int y;

    FoodManager(CanvasWindow canvas) {
        x = 0;
        y = 0;
        location = new Point(x, y);
        food = new Food(location);
        this.canvas = canvas;
    }

    /**
     * If the piece of food is eaten (isEaten), then the food dissapears and is added
     * to a new spot on the canvas.
     */
     public void foodEaten(boolean isEaten) {
        if (isEaten) {
            removeFood(food);
            newLocation();
            addFood(food);
        }
     }

    /**
     * Removes piece of food from canvas
     */
    public void removeFood(Food food) {
        canvas.remove(food.makeFood());
    }

    /**
     * Adds piece of food to the canvas
     */
    public void addFood(Food food) {
        canvas.add(food.makeFood());
    }

    /** 
     * Sets the piece of food to a new random spot on the canvas. Will have to add
     * ability to see where snake is and not place food there.
     */
    public void newLocation() {
        x = new Random().nextInt(canvas.getWidth());
        y = new Random().nextInt(canvas.getWidth());
        location = new Point(x, y);
        food.setCenter(location);
    }

}
