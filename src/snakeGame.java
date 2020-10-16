import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;

public class snakeGame {
        private static final int CANVAS_WIDTH = 800;
        private static final int CANVAS_HEIGHT = 600;
        private static CanvasWindow canvas;
        private Snake snake;
        
        public static void main(String[] args) {   
            snakeGame game = new snakeGame(); 
            game.createSnake();
    }
     
    /**
     * Main Snake game method that animates the canvas
     */
    public snakeGame() {
        canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);
        // canvas.animate(() -> {snake.move();
        //                     });
                           
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.LEFT_ARROW) {
                snake.moveLeft();
            }
            if (event.getKey() == Key.RIGHT_ARROW) {
                snake.moveRight();
            }
            if (event.getKey() == Key.UP_ARROW) {
                snake.moveUp();
            }
            if (event.getKey() == Key.DOWN_ARROW) {
                snake.moveDown();
            }
        });   
    }
    private void createSnake() {
        snake = new Snake(canvas);
        canvas.add(snake);
        canvas.draw();
    }
}
