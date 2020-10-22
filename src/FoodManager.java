import java.util.Random;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public class FoodManager extends GraphicsGroup {

    public Food food;

    private Point location;

    private Point check1;
    private Point check2;
    private Point check3;
    private Point check4;

    private GraphicsGroup group;

    private int x;
    private int y;

    FoodManager(GraphicsGroup group) {
        this.group = group;
        x = new Random().nextInt(SnakeGame.CANVAS_WIDTH);
        y = new Random().nextInt(SnakeGame.CANVAS_HEIGHT);
        location = new Point(x, y);
        food = new Food(location);
        addFood();
    }

    /**
     * If the piece of food is eaten (isEaten), then the food dissapears and is added
     * to a new spot on the canvas.
     */

    /**
     * Removes piece of food from canvas
     */

    /**
     * Adds piece of food to the canvas
     */
    public void addFood() {
        food = new Food(location);
        newLocation();
        this.add(food);
    }

    /** 
     * Sets the piece of food to a new random spot on the canvas. Will have to add
     * ability to see where snake is and not place food there.
     */
    public void newLocation() {
        x = new Random().nextInt(SnakeGame.CANVAS_WIDTH);
        y = new Random().nextInt(SnakeGame.CANVAS_HEIGHT);
        location = new Point(x, y);
        check1 = new Point(x + food.getRadius(), y + food.getRadius());
        check2 = new Point(x + food.getRadius(), y - food.getRadius());
        check3 = new Point(x - food.getRadius(), y + food.getRadius());
        check4 = new Point(x - food.getRadius(), y - food.getRadius());
        while(group.getElementAt(check1) != null || 
        group.getElementAt(check2) != null || 
        group.getElementAt(check3) != null || 
        group.getElementAt(check4) != null ||
        x - food.getRadius() < 0 || x + food.getRadius() > SnakeGame.CANVAS_WIDTH ||
        y - food.getRadius() < 0 || y + food.getRadius() > SnakeGame.CANVAS_HEIGHT) {
            x = new Random().nextInt(SnakeGame.CANVAS_WIDTH);
            y = new Random().nextInt(SnakeGame.CANVAS_HEIGHT);
            location = new Point(x, y);
            check1 = new Point(x + food.getRadius(), y + food.getRadius());
            check2 = new Point(x + food.getRadius(), y - food.getRadius());
            check3 = new Point(x - food.getRadius(), y + food.getRadius());
            check4 = new Point(x - food.getRadius(), y - food.getRadius());
        }
        food.setCenter(location);
    }

}
