import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public class Collision {

    private Snake snake;

    private GraphicsGroup foodPieces;

    private WallManager wallManager;

    private CanvasWindow canvas;


    /**
     * 
     * Tests for distance between the snake and the food, returning true if the two are
     * close. Can add collisions for walls and passages to to other side of screen 
     * later.
     * 
     */

    public Collision (Snake snake, GraphicsGroup foodPieces, WallManager wallManager, CanvasWindow canvas) {
        this.foodPieces = foodPieces;
        this.snake = snake;
        this.wallManager = wallManager;
        this.canvas = canvas;
    }

    public boolean eatsFood() {
        Point leftEye = snake.snakeEyes().get(0);
        Point rightEye = snake.snakeEyes().get(1);

        if (foodPieces.getElementAt(leftEye) == null && 
                    foodPieces.getElementAt(rightEye) == null){
            return false;
        }
        else if (foodPieces.getElementAt(leftEye) != null) {
            foodPieces.remove(foodPieces.getElementAt(leftEye));
            return true;
        }
        else {
            foodPieces.remove(foodPieces.getElementAt(rightEye));
            return true;
        }
    }

    public boolean eatsFood2() {
        Point leftEye = snake.snakeEyes().get(0);
        Point rightEye = snake.snakeEyes().get(1);

        if (foodPieces.getElementAt(leftEye) == null && 
                    foodPieces.getElementAt(rightEye) == null){
            return false;
        }
        else if (foodPieces.getElementAt(leftEye) != null) {
            return true;
        }
        else if (foodPieces.getElementAt(rightEye) != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean wallCollision() {
        GraphicsGroup wallGroup = wallManager.getWallGroup();
        Point leftEye = snake.snakeEyes().get(0);
        Point rightEye = snake.snakeEyes().get(1);

        if (wallGroup.getElementAt(leftEye) == null && 
                    foodPieces.getElementAt(rightEye) == null){
            return false;
        }
        else if (wallGroup.getElementAt(leftEye) != null) {
            return true;
        }
        else if (wallGroup.getElementAt(rightEye) != null) {
            return true;
        }
        return false;
    }

    public boolean snakeCollision() {
        Point leftEye = snake.snakeEyes().get(0);
        Point rightEye = snake.snakeEyes().get(1);

        if (canvas.getElementAt(leftEye) instanceof Segments) {
            return true;
        }
        else if (canvas.getElementAt(rightEye) instanceof Segments) {
            return true;
        }
        else {
            return false;
        }
    }
}
