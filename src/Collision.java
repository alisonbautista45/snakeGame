import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

public class Collision {

    private Snake snake;
    private Food food;
    private CanvasWindow canvas;

    // private List<Point> snakeHead;


    /**
     * 
     * Tests for distance between the snake and the food, returning true if the two are
     * close. Can add collisions for walls and passages to to other side of screen 
     * later.
     * 
     */

    public Collision (CanvasWindow canvas, Snake snake, Food food) {
        this.canvas = canvas;
        this.snake = snake;
        this.food = food;
        // this.snakeHead = snake.updateHead();
    }

    public boolean eatsFood() {
        // if(this.foodFinder(snakeHead)) 
        if (Math.hypot(food.getCenterX() - snake.getX(), 
                                food.getCenterY() - snake.getY()) < food.radius + 5)
        {
            return true;
        }
        else {
            return false;
        }
    }

    // private boolean foodFinder(List<Point> points) {
    //     for (Point point : points) {
    //         if (Math.hypot(food.getCenterX() - point.getX(), 
    //                             food.getCenterY() - point.getY()) < food.radius) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }


     /**
     * checks if the given position has collided with a wall.
     * @param position the center of the snake's head.
     * @return true if there was a collision, false if there wasn't one.
     */
    public boolean wallCollision(Point position) {
        GraphicsObject collision = canvas.getElementAt(position);
        if (collision instanceof Wall) {
            return true;
        } else {
            return false;
        }
    }
}
