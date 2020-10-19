import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public class Collision {

    private Snake snake;

    private GraphicsGroup group;

    private GraphicsGroup foodPieces;

    private CanvasWindow canvas;


    /**
     * 
     * Tests for distance between the snake and the food, returning true if the two are
     * close. Can add collisions for walls and passages to to other side of screen 
     * later.
     * 
     */

    public Collision (Snake snake, GraphicsGroup group, GraphicsGroup foodPieces, CanvasWindow canvas) {
        this.group = group;
        this.foodPieces = foodPieces;
        this.snake = snake;
        this.canvas = canvas;
    }

    public boolean eatsFood() {
        double X = snake.getX();
        double Y = snake.getY();
        if (foodPieces.getElementAt(X - 0.1, Y - 0.1) == null){
            return false;
        }
        else {
            foodPieces.remove(foodPieces.getElementAt(X - 0.1, Y - 0.1));
            return true;
        }
    }

    public boolean eatsFood2() {
        double X = snake.getX();
        double Y = snake.getY();
        if (foodPieces.getElementAt(X - 0.1, Y - 0.1) == null){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean wallCollision() {
        if (canvas.getElementAt(snake.getCenter()) instanceof Wall) {
            return true;
        } else {
            return false;
        }

    }
}
