import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Snake extends Rectangle {
    private double speed = 2;
    private static double x;
    private static double y;
    private double dx = 0;
    private double dy = 0;
    private static double width = 10;
    private static double height = 10;
    public CanvasWindow canvas;

    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;

    
    /**
     * Sets snake dimensions
     */
    public Snake(CanvasWindow canvas) {
        super(x, y, width, height);
        x = canvas.getWidth() * .4;
        y = canvas.getHeight() * 0.9;
        this.setFilled(true);
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = false;
        this.canvas = canvas;
        this.updatePosition();
    }

    /**
     * Moves the snake left
     */
    public void moveLeft() {
        dx = - speed;
        dy = 0;
        if (this.getX() + dx <= 0) {
            dx = 0;
        }
        if (this.getX() + width + dx >= canvas.getWidth()) {
            dx = 0;
        }
        this.updatePosition();
        movingLeft = true;
        movingRight = false;
        movingUp = false;
        movingDown = false;
    }

    /**
     * Moves the snake right
     */
    public void moveRight() {
        dx = speed;
        dy = 0;
        if (this.getX() + dx <= 0) {
            dx = 0;
        }
        if (this.getX() + width + dx >= canvas.getWidth()) {
            dx = 0;
        }
        this.updatePosition();
        movingLeft = false;
        movingRight = true;
        movingUp = false;
        movingDown = false;
    }
    

    public void moveUp() {
        dx = 0;
        dy = - speed;
        if (this.getY() + dy <= 0) {
            dy = 0;
        }
        if (this.getY() + width + dy >= canvas.getHeight()) {
            dy = 0;
        }
        this.updatePosition();
        movingLeft = false;
        movingRight = false;
        movingUp = true;
        movingDown = false;
    }

    public void moveDown() {
        dx = 0;
        dy = speed;
        if (this.getY() + dy <= 0) {
            dy = 0;
        }
        if (this.getY() + width + dy >= canvas.getHeight()) {
            dy = 0;
        }
        this.updatePosition();
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = true;
    }

    /**
     * Updates the postion of the snake
     */
    public void updatePosition() {
        this.setPosition(this.getX() + dx, this.getY() + dy);
    }

    public void addToPath(List<Point> path) {
        Point point = new Point(this.getX(), this.getY());
        path.add(point);
    }

    public void removeSnake (boolean snakeCollision){
        canvas.remove(this);
    }
    
    public List<Point> snakeEyes() {
        List<Point> eyes = new ArrayList<>();
        Point leftEye = new Point(this.getCenter().getX() + 5, this.getCenter().getY() - 5.05);
        Point rightEye = new Point(this.getCenter().getX() - 5, this.getCenter().getY() - 5.05);
        if (movingLeft) {
            leftEye = new Point(this.getCenter().getX() - 5.05, this.getCenter().getY() + 5);
            rightEye = new Point(this.getCenter().getX() - 5.05, this.getCenter().getY() - 5);
        }
        if (movingRight) {
            leftEye = new Point(this.getCenter().getX() + 5.05, this.getCenter().getY() - 5);
            rightEye = new Point(this.getCenter().getX() + 5.05, this.getCenter().getY() + 5);
        }
        if (movingUp) {
            leftEye = new Point(this.getCenter().getX() + 5, this.getCenter().getY() - 5.05);
            rightEye = new Point(this.getCenter().getX() - 5, this.getCenter().getY() - 5.05);
        }
        if (movingDown) {
            leftEye = new Point(this.getCenter().getX() + 5, this.getCenter().getY() + 5.05);
            rightEye = new Point(this.getCenter().getX() - 5, this.getCenter().getY() + 5.05);
        }
        eyes.clear();
        eyes.add(leftEye);
        eyes.add(rightEye);
        return eyes;
    }
}
