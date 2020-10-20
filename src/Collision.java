import edu.macalester.graphics.GraphicsGroup;

public class Collision {

    private Snake snake;

    private GraphicsGroup group;

    private GraphicsGroup foodPieces;

    private WallManager wallManager;


    /**
     * 
     * Tests for distance between the snake and the food, returning true if the two are
     * close. Can add collisions for walls and passages to to other side of screen 
     * later.
     * 
     */

    public Collision (Snake snake, GraphicsGroup group, GraphicsGroup foodPieces, WallManager wallManager) {
        this.group = group;
        this.foodPieces = foodPieces;
        this.snake = snake;
        this.wallManager = wallManager;
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
        GraphicsGroup wallGroup = wallManager.getWallGroup();
        if (wallGroup.getElementAt(snake.getCenter()) != null) {
            return true;
        } else {
            return false;
        }

    }
}
