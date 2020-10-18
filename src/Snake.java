import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Snake extends Rectangle {
    private double speed = 2;
    private static double x;
    private static double y;
    private double dx = 0;
    private double dy = 0;
    private static double width = 10;
    private static double height = 10;
    private CanvasWindow canvas;
    
    /**
     * Sets snake dimensions
     */
    public Snake(CanvasWindow canvas) {
        super(x, y, width, height);
        x = canvas.getWidth() * .4;
        y = canvas.getHeight() * 0.9;
        this.setFilled(true);
        this.canvas = canvas;
        this.updatePosition();
    }

    /**
     * Moves the snake on the canvas by changing its direction
     */
    public void move() {
        // x += speed;
        // if (x <= 0) {
        //     x = 0;
        // }
        // if (x + width >= canvas.getWidth()) {
        //     x = canvas.getWidth() - width;
        // }
        // this.updatePosition();

        
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
    }

    /**
     * Updates the postion of the snake
     */
    public void updatePosition() {
        this.setPosition(this.getX() + dx, this.getY() + dy);
    }
}
