import edu.macalester.graphics.CanvasWindow;

public class WallManager {

    private static final double CANVAS_WIDTH = 800;//SnakeGame.CANVAS_WIDTH;
    private static final double CANVAS_HEIGHT = 600;//SnakeGame.CANVAS_HEIGHT;

    private static final double SMALLER_SIDE = 50;

    private CanvasWindow canvas;

    public WallManager(CanvasWindow canvas) {
        this.canvas = canvas;
    }

    /**
     * Creates borders around the canvas.
     */
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

    /**
     * Creates two vertical walls at 1/3 and 2/3 of the width of canvas with openings for the snake to go through.
     */
    public void generateDoors() {
        Wall wall1 = new Wall((CANVAS_WIDTH / 3) - SMALLER_SIDE, 0, SMALLER_SIDE, CANVAS_HEIGHT / 3);
        canvas.add(wall1);

        Wall wall2 = new Wall((CANVAS_WIDTH/3) - SMALLER_SIDE, (CANVAS_HEIGHT / 3) + SMALLER_SIDE, SMALLER_SIDE, (2 * CANVAS_HEIGHT / 3) - SMALLER_SIDE);
        canvas.add(wall2);

        Wall wall3 = new Wall((2 * CANVAS_WIDTH / 3) - SMALLER_SIDE, 0, SMALLER_SIDE, 2 * CANVAS_HEIGHT / 3);
        canvas.add(wall3);

        Wall wall4 = new Wall((2 * CANVAS_WIDTH / 3) - SMALLER_SIDE, (2 * CANVAS_HEIGHT / 3) + SMALLER_SIDE, SMALLER_SIDE, (CANVAS_HEIGHT / 3) - SMALLER_SIDE);
        canvas.add(wall4);

    }

    /**
     * Creates a simple maze for snake to navigate.
     */
    public void generateSimpleMaze() {
        Wall wall1 = new Wall(0, 0, SMALLER_SIDE, 2 * CANVAS_HEIGHT / 3);
        canvas.add(wall1);

        Wall wall2 = new Wall(0, (2 * CANVAS_HEIGHT / 3) + SMALLER_SIDE, SMALLER_SIDE, (CANVAS_HEIGHT / 3) - SMALLER_SIDE);
        canvas.add(wall2);

        Wall wall3 = new Wall(CANVAS_WIDTH / 3, CANVAS_HEIGHT / 3, 2 * CANVAS_WIDTH / 3, SMALLER_SIDE);
        canvas.add(wall3);

        Wall wall4 = new Wall(CANVAS_WIDTH / 3, (CANVAS_HEIGHT / 3) + SMALLER_SIDE, SMALLER_SIDE, CANVAS_HEIGHT / 3);
        canvas.add(wall4);

        Wall wall5 = new Wall(CANVAS_WIDTH / 3, (2 * CANVAS_HEIGHT / 3) + SMALLER_SIDE, CANVAS_WIDTH / 3, SMALLER_SIDE);
        canvas.add(wall5);

        Wall wall6 = new Wall(CANVAS_WIDTH - SMALLER_SIDE, 2 * CANVAS_HEIGHT / 3, SMALLER_SIDE, CANVAS_HEIGHT / 3);
        canvas.add(wall6);
    }

    /**
     * Creates a herder maze for snake to navigate.
     */
    public void generateHarderMaze() {
        Wall wall1 = new Wall(0, 0, (CANVAS_WIDTH / 2) - SMALLER_SIDE, SMALLER_SIDE);
        canvas.add(wall1);

        Wall wall2 = new Wall((CANVAS_WIDTH / 2) + SMALLER_SIDE, 0, (CANVAS_WIDTH / 2) - SMALLER_SIDE, SMALLER_SIDE);
        canvas.add(wall2);

        Wall wall3 = new Wall(0, CANVAS_HEIGHT / 4, CANVAS_WIDTH / 3, SMALLER_SIDE);
        canvas.add(wall3);

        Wall wall4 = new Wall((CANVAS_WIDTH / 3) - SMALLER_SIDE, (CANVAS_HEIGHT / 4) + SMALLER_SIDE, SMALLER_SIDE, CANVAS_HEIGHT / 3);
        canvas.add(wall4);

        Wall wall5 = new Wall(2 * CANVAS_WIDTH / 3, (CANVAS_HEIGHT / 4) + SMALLER_SIDE, SMALLER_SIDE, CANVAS_HEIGHT/3);
        canvas.add(wall5);

        Wall wall6 = new Wall(2 * CANVAS_WIDTH / 3, (7 * CANVAS_HEIGHT / 12) + SMALLER_SIDE, CANVAS_WIDTH / 3, SMALLER_SIDE);
        canvas.add(wall6);

        Wall wall7 = new Wall(CANVAS_WIDTH / 4, (3 * CANVAS_HEIGHT / 4) + SMALLER_SIDE, CANVAS_WIDTH / 2, SMALLER_SIDE);
        canvas.add(wall7);
    }
}
