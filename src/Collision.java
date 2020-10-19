import java.util.List;

import edu.macalester.graphics.CanvasWindow;
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

    public Collision (Snake snake, CanvasWindow canvas) {
        this.snake = snake;
        this.food = food;
        this.canvas = canvas;
        // this.snakeHead = snake.updateHead();
    }

    public boolean eatsFood() {
        // if(this.foodFinder(snakeHead)) 
        double X = snake.getX();
        double Y = snake.getY();
        if (canvas.getElementAt(X, Y) instanceof Food) {
            canvas.remove(canvas.getElementAt(X, Y));
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
}
