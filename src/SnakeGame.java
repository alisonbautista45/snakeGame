import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;

public class SnakeGame {
        private static final int CANVAS_WIDTH = 800;
        private static final int CANVAS_HEIGHT = 600;
        private static CanvasWindow canvas;
        private Snake snake;
        
        public static void main(String[] args) {   
            SnakeGame game = new SnakeGame(); 
            game.createSnake();
    }
     
    /**
     * Main Snake game method that animates the canvas
     */
    public SnakeGame() {
        canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.animate(() -> {snake.move();
                            });
                           
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.LEFT_ARROW) {
                canvas.animate(() -> snake.moveLeft());
            }
            if (event.getKey() == Key.RIGHT_ARROW) {
                canvas.animate(() -> snake.moveRight());
            }
            if (event.getKey() == Key.UP_ARROW) {
                canvas.animate(() -> snake.moveUp());
            }
            if (event.getKey() == Key.DOWN_ARROW) {
                canvas.animate(() ->snake.moveDown());
            }
        });   
    }
    private void createSnake() {
        snake = new Snake(canvas);
        canvas.add(snake);
        canvas.draw();
    }
}
