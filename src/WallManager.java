import edu.macalester.graphics.CanvasWindow;

public class WallManager {

    private static final double CANVAS_WIDTH = 800;//SnakeGame.CANVAS_WIDTH;
    private static final double CANVAS_HEIGHT = 600;//SnakeGame.CANVAS_HEIGHT;

    private static final double SMALLER_SIDE = 50;

    private CanvasWindow canvas;

    public WallManager(CanvasWindow canvas) {
        this.canvas = canvas;
    }

    public void generateBorders() {
        Wall wall1 = new Wall(0, 0, CANVAS_WIDTH - SMALLER_SIDE, SMALLER_SIDE);
        canvas.add(wall1);
        Wall wall2 = new Wall(CANVAS_WIDTH - SMALLER_SIDE, 0, SMALLER_SIDE, CANVAS_HEIGHT - SMALLER_SIDE);
        canvas.add(wall2);
        Wall wall3 = new Wall(SMALLER_SIDE, CANVAS_HEIGHT - SMALLER_SIDE, CANVAS_WIDTH - SMALLER_SIDE, SMALLER_SIDE);
        canvas.add(wall3);
        Wall wall4 = new Wall(0, SMALLER_SIDE, SMALLER_SIDE, CANVAS_HEIGHT - SMALLER_SIDE);
        canvas.add(wall4);
    }

    public void generateDoors() {

    }
}
