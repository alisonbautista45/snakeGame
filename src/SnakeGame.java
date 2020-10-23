import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class SnakeGame extends GraphicsGroup {

        public static final int CANVAS_WIDTH = 800;
        public static final int CANVAS_HEIGHT = 600;

        public static final Color YELLOW = new Color(238, 186, 76);
        public static final Color RED = new Color(227, 73, 59);
        public static final Color AQUA = new Color(35, 181, 175);
        public static final Color LIGHT_AQUA = new Color(169, 221, 217);
        public static final Color DARK_GRAY = new Color(58, 58, 60);
        public static final Color DARK_GREEN = new Color(0, 153, 0);

        private Snake snake;

        private FoodManager food;

        private Collision collide;

        private Segments segments;

        private List<Segments> allSegments = new ArrayList<>();

        private WallManager wallManager;

        private boolean moveLeft;
        private boolean moveRight;
        private boolean moveUp;
        private boolean moveDown;

        private int numSegs;

        private List<Point> path;

        private List<Button> buttons = new ArrayList<>();
        private List<GraphicsText> screenText = new ArrayList<>();

        private GraphicsText score;
        private GraphicsText gameOverScreen;

        private CanvasWindow canvas;

        private SnakeGameWindow window;

        private GraphicsGroup textLayer = new GraphicsGroup();

        
    public static void main(String[] args) {   
        SnakeGameWindow snakeGameWindow = new SnakeGameWindow(); 
        snakeGameWindow.newGame().homeScreen();
    }
     
    /**
     * Main Snake game method that animates the canvas
     */
    public SnakeGame(CanvasWindow canvas, SnakeGameWindow window) {

        this.canvas = canvas;
        this.window = window;

        numSegs = 0;

        path = new ArrayList<>();

        moveLeft = false;
        moveRight = false;
        moveUp = false;
        moveDown = false;

        food = new FoodManager(canvas);
        snake = new Snake(this);

        wallManager = new WallManager();
        this.add(wallManager);

        collide = new Collision(snake, food, wallManager, this);    
        
        score = new GraphicsText("Score: " + numSegs);
        score.setCenter(CANVAS_WIDTH * 0.1, CANVAS_HEIGHT * 0.1);
    }

    private void run() {
        this.add(food);
        this.add(snake);
        textLayer.add(score);
    }

    private void addingSegments(List<Point> path) {
        numSegs++;
        segments = new Segments(snake, path, numSegs);
        segments.addToGroup();
        allSegments.add(segments);
        updateScore();
        this.add(segments.getSegmentsGroup());
    }

    private void following() { 
        for(Segments segs : allSegments) {
            if (allSegments.get(numSegs - 1) == segs) {
                segs.setScale(0.4);
                segs.setStrokeWidth(0.4);
            }
            else if (allSegments.get(numSegs - 2) == segs) {
                segs.setScale(0.6);
                segs.setStrokeWidth(0.4);
            }
            else if (allSegments.get(numSegs - 3) == segs) {
                segs.setScale(0.8);
                segs.setStrokeWidth(0.4);
            }
            else {
                segs.setScale(1);
            }
            segs.follow();
        }
    }

    private void checkForCollision() {
        if (collide.wallCollision()) {
            this.removeAll();
            gameOverScreen();
        }
        if (collide.snakeCollision()){
            this.removeAll();
            gameOverScreen();
        }
    }

    private void updateScore() {
        textLayer.remove(score);
        score = new GraphicsText("Score: " + numSegs);
        score.setCenter(CANVAS_WIDTH * 0.1, CANVAS_HEIGHT * 0.1);
        textLayer.add(score);
    }

    public void onKeyDown(KeyboardEvent event) {
            if ((event.getKey() == Key.LEFT_ARROW && moveRight != true) || 
            (event.getKey() == Key.LEFT_ARROW && numSegs == 0)) {
                moveRight = false;
                moveUp = false;
                moveDown = false;
                moveLeft = true;
            }
            if ((event.getKey() == Key.RIGHT_ARROW && moveLeft != true) ||
            (event.getKey() == Key.RIGHT_ARROW && numSegs == 0)) {
                moveLeft = false;
                moveUp = false;
                moveDown = false;
                moveRight = true;
            }
            if ((event.getKey() == Key.UP_ARROW && moveDown != true) ||
            (event.getKey() == Key.UP_ARROW && numSegs == 0)) {
                moveLeft = false;
                moveRight = false;
                moveDown = false;
                moveUp = true;
            }
            if ((event.getKey() == Key.DOWN_ARROW && moveUp != true) ||
            (event.getKey() == Key.DOWN_ARROW && numSegs == 0)) {
                moveLeft = false;
                moveRight = false;
                moveUp = false;
                moveDown = true;
            }   
    }

    public void animate() {
            checkForCollision();
            if (collide.eatsFood()) {
                addingSegments(path);
                food.addFood();
            }
            snake.addToPath(path);
            if(moveLeft) {
                snake.moveLeft();
            }
            if(moveRight) {
                snake.moveRight();
            }
            if(moveUp) {
                snake.moveUp();
            }
            if(moveDown) {
                snake.moveDown();
            }
            following();
    }
        
    // ---------------------------------------

    // >>>>> HOME SCREEN RELATED METHODS <<<<<

    // ---------------------------------------

    private void homeScreen() {
        canvas.add(this);
        canvas.add(textLayer);
        levelButtons();
        welcomeText();
        startButton();
    }

    private void welcomeText() {
        GraphicsText title = new GraphicsText();
        title.setText("SNAKE GAME");
        title.setFillColor(DARK_GRAY);
        title.setCenter(CANVAS_WIDTH / 5, CANVAS_HEIGHT / 3);
        title.setFont(FontStyle.BOLD, 80);
        textLayer.add(title);
        screenText.add(title);
        GraphicsText chooseLevel = new GraphicsText();
        chooseLevel.setText("Choose your level");
        chooseLevel.setFillColor(DARK_GRAY);
        chooseLevel.setCenter(CANVAS_WIDTH / 5, 2 * CANVAS_HEIGHT / 3);
        chooseLevel.setFont(FontStyle.BOLD, 60);
        textLayer.add(chooseLevel);
        screenText.add(chooseLevel);
    }

    private void startButton() {
        Button start = new Button("Start!");
        start.setCenter(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
        textLayer.add(start);
        buttons.add(start);
        start.onClick(() -> {
            for (Button button : buttons) {
                textLayer.remove(button);
            }
            for (GraphicsText text : screenText) {
                textLayer.remove(text);
            }
            run();
        });
    }

    private void levelButtons() {
        Button basic = new Button("No Obstacles");
        basic.setPosition(50, 3 * CANVAS_HEIGHT / 4);
        textLayer.add(basic);
        buttons.add(basic);
        basic.onClick(() -> wallManager.removeAll());
        Button borders = new Button("Borders");
        borders.setPosition(200, 3 * CANVAS_HEIGHT / 4);
        textLayer.add(borders);
        buttons.add(borders);
        borders.onClick(() -> {
            wallManager.removeAll();
            wallManager.generateBorders();
        });

        Button doors = new Button("Doors");
        doors.setPosition(300, 3 * CANVAS_HEIGHT / 4);
        textLayer.add(doors);
        buttons.add(doors);
        doors.onClick(() -> {
            wallManager.removeAll();
            wallManager.generateDoors();
        });

        Button simpleMaze = new Button("Simple Maze");
        simpleMaze.setPosition(400, 3 * CANVAS_HEIGHT / 4);
        textLayer.add(simpleMaze);
        buttons.add(simpleMaze);
        simpleMaze.onClick(() -> {
            wallManager.removeAll();
            wallManager.generateSimpleMaze();
        });

        Button harderMaze = new Button("Not So Simple Maze");
        harderMaze.setPosition(550, 3 * CANVAS_HEIGHT / 4);
        textLayer.add(harderMaze);
        buttons.add(harderMaze);
        harderMaze.onClick(() -> {
            wallManager.removeAll();
            wallManager.generateHarderMaze();
        });
    }

    private void gameOverScreen() {
        gameOverScreen = new GraphicsText();
        gameOverScreen.setFont(FontStyle.ITALIC, 65);
        gameOverScreen.setText("Game Over");
        gameOverScreen.setFillColor(RED);
        moveLeft = false;
        moveRight = false;
        moveUp = false;
        moveDown = false;
        Point center = new Point(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
        snake.setCenter(center);
        this.removeAll();
        this.add(gameOverScreen);
        score.setCenter(CANVAS_WIDTH / 2 - score.getWidth(), CANVAS_HEIGHT / 3);
        score.setFont(FontStyle.BOLD, 40);
        gameOverScreen.setCenter(center);
        replayGame();
    }

    private void replayGame() {
        Button replay = new Button("Replay");
        replay.setCenter(CANVAS_WIDTH / 2, 2 * CANVAS_HEIGHT / 3);
        this.add(replay);
        replay.onClick(() -> {
            this.removeAll();
            textLayer.removeAll();
            window.newGame().homeScreen();
        });
    }
}
