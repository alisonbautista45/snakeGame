import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Snake extends Rectangle{
    private double speed = 20;
    private static double x;
    private static double y;
    private static double width = 10;
    private static double height = 10;
    private CanvasWindow canvas;

/**
 * Sets snake dimensions
 */
    public Snake(CanvasWindow canvas) {
        super(x, y, width, height);
        this.setFilled(true);
        this.canvas = canvas;
        x = canvas.getWidth()*.4;
        y = canvas.getHeight()*0.9;
        this.updatePosition();
    }

/**
 * Moves the snake on the canvas by changing its direction
 */
    public void moveX(double speed) {
            x += speed;
            this.updatePosition();
            if (x <= 0) {
                x = 0;
                this.updatePosition();
            }
            if (x + width >= canvas.getWidth()) {
                x = canvas.getWidth() - width;
                this.updatePosition();
            }    
    }
    public void moveY(double speed) {
        y += speed;
            this.updatePosition();
            if (y <= 0) {
                y = 0;
                this.updatePosition();
            }
            if (y + width >= canvas.getHeight()) {
                y = canvas.getHeight() - height;
                this.updatePosition();
            } 
    }

/**
 * Moves the snake left
 */
    public void moveLeft(){
        moveX(-speed);
    }

/**
 * Moves the snake right
 */
    public void moveRight(){
        moveX(speed);
    }

    public void moveUp(){
        moveY(-speed);
    }

    public void moveDown(){
        moveY(speed);
    }

/**
 * Updates the postion of the snake
 */
    public void updatePosition(){
        this.setPosition(x, y);   
    } 
}
