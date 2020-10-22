import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;

public class WallManager extends GraphicsGroup {

    private static final double CANVAS_WIDTH = SnakeGame.CANVAS_WIDTH;
    private static final double CANVAS_HEIGHT = SnakeGame.CANVAS_HEIGHT;

    private static final double SMALLER_SIDE = 50;

    private GraphicsGroup group;
    private List<Wall> walls;
    private GraphicsGroup wallGroup;

    public WallManager(GraphicsGroup group) {
        this.group = group;
        wallGroup = new GraphicsGroup();
        walls = new ArrayList<>();
    }

    /**
     * Creates borders around the canvas.
     */
    public void generateBorders() {
        Wall wall1 = new Wall(0, 0, CANVAS_WIDTH - SMALLER_SIDE, SMALLER_SIDE);
        group.add(wall1);
        walls.add(wall1);
        wallGroup.add(wall1);

        Wall wall2 = new Wall(CANVAS_WIDTH - SMALLER_SIDE, 0, SMALLER_SIDE, CANVAS_HEIGHT - SMALLER_SIDE);
        group.add(wall2);
        walls.add(wall2);
        wallGroup.add(wall2);

        Wall wall3 = new Wall(SMALLER_SIDE, CANVAS_HEIGHT - SMALLER_SIDE, CANVAS_WIDTH - SMALLER_SIDE, SMALLER_SIDE);
        group.add(wall3);
        walls.add(wall3);
        wallGroup.add(wall3);


        Wall wall4 = new Wall(0, SMALLER_SIDE, SMALLER_SIDE, CANVAS_HEIGHT - SMALLER_SIDE);
        group.add(wall4);
        walls.add(wall4);
        wallGroup.add(wall4);
    }

    /**
     * Creates two vertical walls at 1/3 and 2/3 of the width of canvas with openings for the snake to go through.
     */
    public void generateDoors() {
        Wall wall1 = new Wall((CANVAS_WIDTH / 3) - SMALLER_SIDE, 0, SMALLER_SIDE, CANVAS_HEIGHT / 3);
        group.add(wall1);
        walls.add(wall1);
        wallGroup.add(wall1);

        Wall wall2 = new Wall((CANVAS_WIDTH/3) - SMALLER_SIDE, (CANVAS_HEIGHT / 3) + SMALLER_SIDE, SMALLER_SIDE, (2 * CANVAS_HEIGHT / 3) - SMALLER_SIDE);
        group.add(wall2);
        walls.add(wall2);
        wallGroup.add(wall2);

        Wall wall3 = new Wall((2 * CANVAS_WIDTH / 3) - SMALLER_SIDE, 0, SMALLER_SIDE, 2 * CANVAS_HEIGHT / 3);
        group.add(wall3);
        walls.add(wall3);
        wallGroup.add(wall3);

        Wall wall4 = new Wall((2 * CANVAS_WIDTH / 3) - SMALLER_SIDE, (2 * CANVAS_HEIGHT / 3) + SMALLER_SIDE, SMALLER_SIDE, (CANVAS_HEIGHT / 3) - SMALLER_SIDE);
        group.add(wall4);
        walls.add(wall4);
        wallGroup.add(wall4);

    }

    /**
     * Creates a simple maze for snake to navigate.
     */
    public void generateSimpleMaze() {
        Wall wall1 = new Wall(0, 0, SMALLER_SIDE, 2 * CANVAS_HEIGHT / 3);
        group.add(wall1);
        walls.add(wall1);
        wallGroup.add(wall1);

        Wall wall2 = new Wall(0, (2 * CANVAS_HEIGHT / 3) + SMALLER_SIDE, SMALLER_SIDE, (CANVAS_HEIGHT / 3) - SMALLER_SIDE);
        group.add(wall2);
        walls.add(wall2);
        wallGroup.add(wall2);

        Wall wall3 = new Wall(CANVAS_WIDTH / 3, CANVAS_HEIGHT / 3, 2 * CANVAS_WIDTH / 3, SMALLER_SIDE);
        group.add(wall3);
        walls.add(wall3);
        wallGroup.add(wall3);

        Wall wall4 = new Wall(CANVAS_WIDTH / 3, (CANVAS_HEIGHT / 3) + SMALLER_SIDE, SMALLER_SIDE, CANVAS_HEIGHT / 3);
        group.add(wall4);
        walls.add(wall4);
        wallGroup.add(wall4);

        Wall wall5 = new Wall(CANVAS_WIDTH / 3, (2 * CANVAS_HEIGHT / 3) + SMALLER_SIDE, CANVAS_WIDTH / 3, SMALLER_SIDE);
        group.add(wall5);
        walls.add(wall5);
        wallGroup.add(wall5);

        Wall wall6 = new Wall(CANVAS_WIDTH - SMALLER_SIDE, 3 * CANVAS_HEIGHT / 4, SMALLER_SIDE, CANVAS_HEIGHT / 4);
        group.add(wall6);
        walls.add(wall6);
        wallGroup.add(wall6);
    }

    /**
     * Creates a herder maze for snake to navigate.
     */
    public void generateHarderMaze() {
        Wall wall1 = new Wall(0, 0, (CANVAS_WIDTH / 2) - SMALLER_SIDE, SMALLER_SIDE);
        group.add(wall1);
        walls.add(wall1);
        wallGroup.add(wall1);

        Wall wall2 = new Wall((CANVAS_WIDTH / 2) + SMALLER_SIDE, 0, (CANVAS_WIDTH / 2) - SMALLER_SIDE, SMALLER_SIDE);
        group.add(wall2);
        walls.add(wall2);
        wallGroup.add(wall2);

        Wall wall3 = new Wall(0, CANVAS_HEIGHT / 4, CANVAS_WIDTH / 3, SMALLER_SIDE);
        group.add(wall3);
        walls.add(wall3);
        wallGroup.add(wall3);

        Wall wall4 = new Wall((CANVAS_WIDTH / 3) - SMALLER_SIDE, (CANVAS_HEIGHT / 4) + SMALLER_SIDE, SMALLER_SIDE, CANVAS_HEIGHT / 3);
        group.add(wall4);
        walls.add(wall4);
        wallGroup.add(wall4);

        Wall wall5 = new Wall(2 * CANVAS_WIDTH / 3, (CANVAS_HEIGHT / 4) + SMALLER_SIDE, SMALLER_SIDE, CANVAS_HEIGHT/3);
        group.add(wall5);
        walls.add(wall5);
        wallGroup.add(wall5);

        Wall wall6 = new Wall(2 * CANVAS_WIDTH / 3, (7 * CANVAS_HEIGHT / 12) + SMALLER_SIDE, CANVAS_WIDTH / 3, SMALLER_SIDE);
        group.add(wall6);
        walls.add(wall6);
        wallGroup.add(wall6);

        Wall wall7 = new Wall(CANVAS_WIDTH / 4, (3 * CANVAS_HEIGHT / 4) + SMALLER_SIDE, CANVAS_WIDTH / 2, SMALLER_SIDE);
        group.add(wall7);
        walls.add(wall7);
        wallGroup.add(wall7);
    }

    public void removeWalls() {
        for (Wall wall : walls) {
            group.remove(wall);
        }
        walls = new ArrayList<>();
        wallGroup.removeAll();;
    }

    public GraphicsGroup getWallGroup() {
        return wallGroup;
    }
}
