import edu.macalester.graphics.CanvasWindow;

public class SnakeGameWindow {

    private int CANVAS_HEIGHT = SnakeGame.CANVAS_HEIGHT;
    private int CANVAS_WIDTH = SnakeGame.CANVAS_WIDTH;

    private SnakeGame currentSnakeGame;
    private CanvasWindow canvas;

    public SnakeGameWindow() {
        this.canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.onKeyDown(event -> { 
            if(currentSnakeGame != null) { 
                currentSnakeGame.onKeyDown(event); 
            }
        });
        canvas.animate(() -> {
            if(currentSnakeGame != null) { 
                currentSnakeGame.animate();
            }
        });
    }

    public SnakeGame newGame() {
        currentSnakeGame = new SnakeGame(this.canvas, this);
        return currentSnakeGame;
    }
    
}
