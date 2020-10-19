import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;

import edu.macalester.graphics.GraphicsGroup;

import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.Point;

public class SnakeGame {
        private static final int CANVAS_WIDTH = 800;
        private static final int CANVAS_HEIGHT = 600;
        private static CanvasWindow canvas;
        private Snake snake;

        private FoodManager food;

        private Collision collide;

        private Segments segments;

        private List<Segments> allSegments = new ArrayList<>();

        private boolean moveLeft;
        private boolean moveRight;
        private boolean moveUp;
        private boolean moveDown;

        private int numSegs;

        private List<Point> path;

        private GraphicsGroup group = new GraphicsGroup();
        private GraphicsGroup foodPieces = new GraphicsGroup();
        
    public static void main(String[] args) {   
        new SnakeGame(); 
    }
     
    /**
     * Main Snake game method that animates the canvas
     */
    public SnakeGame() {

        numSegs = 0;

        path = new ArrayList<>();

        moveLeft = false;
        moveRight = false;
        moveUp = false;
        moveDown = false;

        canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);

        food = new FoodManager(canvas, foodPieces);

        snake = new Snake(canvas);
        snake.setCenter(canvas.getWidth() * 0.5, canvas.getHeight() * 0.9);
        group.add(snake);

        collide = new Collision(snake, group, foodPieces);

        canvas.add(group);
        canvas.add(foodPieces);

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
                addingSegments(path);
                food.foodEaten(collide.eatsFood());
                snake.addToPath(path);
                snake.moveLeft();
            }
            if(moveRight) {
                addingSegments(path);
                food.foodEaten(collide.eatsFood());
                snake.addToPath(path);
                snake.moveRight();
            }
            if(moveUp) {
                addingSegments(path);
                food.foodEaten(collide.eatsFood());
                snake.addToPath(path);
                snake.moveUp();
            }
            if(moveDown) {
                addingSegments(path);
                food.foodEaten(collide.eatsFood());
                snake.addToPath(path);
                snake.moveDown();
            }
        });             
    }

    private void addingSegments(List<Point> path) {
        if(collide.eatsFood2()) {
            numSegs++;
            segments = new Segments(snake, path, numSegs, group);
            segments.addToGroup();
            allSegments.add(segments);
        }
        for(Segments segs : allSegments) {
            segs.follow();
        }
    }
   
}
