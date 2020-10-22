import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;


public class Snake extends GraphicsGroup{
    private int i = 0;
    private double speed = 2;

    private static double x;
    private static double y;
    private double dx = 0;
    private double dy = 0;
    private static double width = 15;
    private static double height = 15;
    public GraphicsGroup group;

    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;

    private GraphicsObject snakeHeadLeft;
    private GraphicsObject snakeHeadRight;
    private GraphicsObject snakeHeadUp;
    private GraphicsObject snakeHeadDown;
    private GraphicsObject snakeHead;
    
    /**
     * Sets snake dimensions
     */
    public Snake(GraphicsGroup group) {
        x = SnakeGame.CANVAS_WIDTH * 0.5;
        y = SnakeGame.CANVAS_HEIGHT * 0.5;
        snakeHead = SnakeHead.createSnakeHead(0);
        snakeHeadLeft = SnakeHead.createSnakeHead(270);
        snakeHeadRight = SnakeHead.createSnakeHead(90);
        snakeHeadUp = SnakeHead.createSnakeHead(0);
        snakeHeadDown = SnakeHead.createSnakeHead(180);
        this.add(snakeHead);
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = false;
        this.group = group;
        this.startPosition();
        // this.updatePosition();
    }

    /**
     * Moves the snake left
     */
    public void moveLeft() {
        dx = - speed;
        dy = 0;
        if (this.getX() + dx <= 0) {
            this.setX(SnakeGame.CANVAS_WIDTH);
        }
        this.updatePosition();
        movingLeft = true;
        movingRight = false;
        movingUp = false;
        movingDown = false;
        turnSnakeHead();
    }

    /**
     * Moves the snake right
     */
    public void moveRight() {
        dx = speed;
        dy = 0;
        if (this.getX() + width + dx >= SnakeGame.CANVAS_WIDTH) {
            this.setX(0);
        }
        this.updatePosition();
        movingLeft = false;
        movingRight = true;
        movingUp = false;
        movingDown = false;
        turnSnakeHead();
    }
    

    public void moveUp() {
        dx = 0;
        dy = - speed;
        if (this.getY() + dy <= 0) {
            this.setY(600);
        }
        this.updatePosition();
        movingLeft = false;
        movingRight = false;
        movingUp = true;
        movingDown = false;
        turnSnakeHead();
    }

    public void moveDown() {
        dx = 0;
        dy = speed;
        if (this.getY() + width + dy >= SnakeGame.CANVAS_HEIGHT) {
            this.setY(0);
        }
        this.updatePosition();
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = true;
        turnSnakeHead();
    }

    /**
     * Updates the postion of the snake
     */ 
    public void updatePosition() {
        this.setPosition(this.getX() + dx, this.getY() + dy);
    }

    private void startPosition() {
        this.setPosition(SnakeGame.CANVAS_WIDTH * 0.5, SnakeGame.CANVAS_HEIGHT * 0.5);
    }

    public void addToPath(List<Point> path) {
        Point point = new Point(this.getX(), this.getY());
        if (movingLeft) {
            if ((i % 32) < 4) {
                point = new Point(this.getX() + 2.5, this.getY());
            }
            else if ((i % 32) >= 4 && (i % 32) < 8) {
                point = new Point(this.getX() + 2.5, this.getY() + 1.25);
            }
            else if ((i % 32) >= 8 && (i % 32) < 12) {
                point = new Point(this.getX() + 2.5, this.getY() + 2.5);
            }
            else if ((i % 32) >= 12 && (i % 32) < 16) {
                point = new Point(this.getX() + 2.5, this.getY() + 1.25);
            }
            else if ((i % 32) >= 16 && (i % 32) < 20) {
                point = new Point(this.getX() + 2.5, this.getY());
            }
            else if ((i % 32) >= 20 && (i % 32) < 24) {
                point = new Point(this.getX() + 2.5, this.getY() - 1.25);
            }
            else if ((i % 32) >= 24 && (i % 32) < 28) {
                point = new Point(this.getX() + 2.5, this.getY() - 2.5);
            }
            else if ((i % 32) >= 28 && (i % 32) < 32) {
                point = new Point(this.getX() + 2.5, this.getY() - 1.25);
            }
        }
        else if (movingRight) {
            if ((i % 32) < 4) {
                point = new Point(this.getX() - 2.5, this.getY());
            }
            else if ((i % 32) >= 4 && (i % 32) < 8) {
                point = new Point(this.getX() - 2.5, this.getY() + 1.25);
            }
            else if ((i % 32) >= 8 && (i % 32) < 12) {
                point = new Point(this.getX() - 2.5, this.getY() + 2.5);
            }
            else if ((i % 32) >= 12 && (i % 32) < 16) {
                point = new Point(this.getX() - 2.5, this.getY() + 1.25);
            }
            else if ((i % 32) >= 16 && (i % 32) < 20) {
                point = new Point(this.getX() - 2.5, this.getY());
            }
            else if ((i % 32) >= 20 && (i % 32) < 24) {
                point = new Point(this.getX() - 2.5, this.getY() - 1.25);
            }
            else if ((i % 32) >= 24 && (i % 32) < 28) {
                point = new Point(this.getX() - 2.5, this.getY() - 2.5);
            }
            else if ((i % 32) >= 28 && (i % 32) < 32) {
                point = new Point(this.getX() - 2.5, this.getY() - 1.25);
            }
        }
        else if (movingUp) {
            if ((i % 32) < 4) {
                point = new Point(this.getX(), this.getY() + 2.5);
            }
            else if ((i % 32) >= 4 && (i % 32) < 8) {
                point = new Point(this.getX() + 1.25, this.getY() + 2.5);
            }
            else if ((i % 32) >= 8 && (i % 32) < 12) {
                point = new Point(this.getX() + 2.5, this.getY() + 2.5);
            }
            else if ((i % 32) >= 12 && (i % 32) < 16) {
                point = new Point(this.getX() + 1.25, this.getY() + 2.5);
            }
            else if ((i % 32) >= 16 && (i % 32) < 20) {
                point = new Point(this.getX(), this.getY() + 2.5);
            }
            else if ((i % 32) >= 20 && (i % 32) < 24) {
                point = new Point(this.getX() - 1.25, this.getY() + 2.5);
            }
            else if ((i % 32) >= 24 && (i % 32) < 28) {
                point = new Point(this.getX() - 2.5, this.getY() + 2.5);
            }
            else if ((i % 32) >= 28 && (i % 32) < 32) {
                point = new Point(this.getX() - 1.25, this.getY() + 2.5);
            }
        }
        else if (movingDown) {
            if ((i % 32) < 4) {
                point = new Point(this.getX(), this.getY() - 2.5);
            }
            else if ((i % 32) >= 4 && (i % 32) < 8) {
                point = new Point(this.getX() + 1.25, this.getY() - 2.5);
            }
            else if ((i % 32) >= 8 && (i % 32) < 12) {
                point = new Point(this.getX() + 2.5, this.getY() - 2.5);
            }
            else if ((i % 32) >= 12 && (i % 32) < 16) {
                point = new Point(this.getX() + 1.25, this.getY() - 2.5);
            }
            else if ((i % 32) >= 16 && (i % 32) < 20) {
                point = new Point(this.getX(), this.getY() - 2.5);
            }
            else if ((i % 32) >= 20 && (i % 32) < 24) {
                point = new Point(this.getX() - 1.25, this.getY() - 2.5);
            }
            else if ((i % 32) >= 24 && (i % 32) < 28) {
                point = new Point(this.getX() - 2.5, this.getY() - 2.5);
            }
            else if ((i % 32) >= 28 && (i % 32) < 32) {
                point = new Point(this.getX() - 1.25, this.getY() - 2.5);
            }
        }
        i++;
        path.add(point);
    }

    public void removeSnake (boolean snakeCollision){
        group.remove(this);
    }
    
    public List<Point> snakeEyes() {
        List<Point> eyes = new ArrayList<>();
        Point leftEye = new Point(this.getCenter().getX() + 7.5, this.getCenter().getY() - 7.55);
        Point rightEye = new Point(this.getCenter().getX() - 7.5, this.getCenter().getY() - 7.55);
        if (movingLeft) {
            leftEye = new Point(this.getCenter().getX() - 7.55, this.getCenter().getY() + 7.5);
            rightEye = new Point(this.getCenter().getX() - 7.55, this.getCenter().getY() - 7.5);
        }
        if (movingRight) {
            leftEye = new Point(this.getCenter().getX() + 7.55, this.getCenter().getY() - 7.5);
            rightEye = new Point(this.getCenter().getX() + 7.55, this.getCenter().getY() + 7.5);
        }
        if (movingUp) {
            leftEye = new Point(this.getCenter().getX() + 7.5, this.getCenter().getY() - 7.55);
            rightEye = new Point(this.getCenter().getX() - 7.5, this.getCenter().getY() - 7.55);
        }
        if (movingDown) {
            leftEye = new Point(this.getCenter().getX() + 7.5, this.getCenter().getY() + 7.55);
            rightEye = new Point(this.getCenter().getX() - 7.5, this.getCenter().getY() + 7.55);
        }
        eyes.clear();
        eyes.add(leftEye);
        eyes.add(rightEye);
        return eyes;
    }

    public void turnSnakeHead() {
        this.remove(snakeHead);
        if (movingLeft) {
            snakeHead = snakeHeadLeft;
            this.add(snakeHead);
        }
        else if (movingRight) {
            snakeHead = snakeHeadRight;
            this.add(snakeHead);
        }
        else if (movingDown) {
            snakeHead = snakeHeadDown;
            this.add(snakeHead);
        }
        else if (movingUp) {
            snakeHead = snakeHeadUp;
            this.add(snakeHead);
        }
}

}
