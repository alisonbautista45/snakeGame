import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;

public class SnakeGame {
        private static final int CANVAS_WIDTH = 800;
        private static final int CANVAS_HEIGHT = 600;
        private static CanvasWindow canvas;
        private Snake snake;

        private FoodManager food;

        private Collision collide;

        private boolean moveLeft;
        private boolean moveRight;
        private boolean moveUp;
        private boolean moveDown;


        
    public static void main(String[] args) {   
        new SnakeGame(); 
    }
     
    /**
     * Main Snake game method that animates the canvas
     */
    public SnakeGame() {

        moveLeft = false;
        moveRight = false;
        moveUp = false;
        moveDown = false;

        canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);

        food = new FoodManager(canvas);
        food.addFood();

        snake = new Snake(canvas);
        snake.setCenter(canvas.getWidth() * 0.5, canvas.getHeight() * 0.9);
        canvas.add(snake);


        canvas.onKeyDown(event-> {
            if (event.getKey() == Key.LEFT_ARROW) {
                moveRight = false;
                moveUp = false;
                moveDown = false;
                moveLeft = true;
            }
            if (event.getKey() == Key.RIGHT_ARROW) {
                moveLeft = false;
                moveUp = false;
                moveDown = false;
                moveRight = true;
            }
            if (event.getKey() == Key.UP_ARROW) {
                moveLeft = false;
                moveRight = false;
                moveDown = false;
                moveUp = true;
            }
            if (event.getKey() == Key.DOWN_ARROW) {
                moveLeft = false;
                moveRight = false;
                moveUp = false;
                moveDown = true;
            }
        });   

        canvas.animate(() -> {
            if(moveLeft) {
                snake.moveLeft();
            }
            if(moveRight) {
                snake.moveRight();
            }
            if(moveUp) {
                snake.moveUp();
            }
            if(moveDown) {
                snake.moveDown();
            }
        });
                           
        
    }
   
}
