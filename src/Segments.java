import java.util.List;
import java.util.concurrent.DelayQueue;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public class Segments extends Snake{

    private List<Point> path;
    private int distance;
    private static GraphicsGroup segments;
    private Snake snake;


    public Segments(Snake snake, List<Point> path, int distance, GraphicsGroup segments) {
        super(snake.canvas);
        this.setFilled(true);
        this.path = path;
        this.distance = distance;
        this.snake = snake;
        this.segments = segments;
    }

    public void follow() {
        this.setPosition(path.get(this.path.size() - distance * 6).getX(),
            path.get(this.path.size() - distance * 6).getY());

    }

    public void addToGroup() {
        this.setCenter(path.get(0).getX(), path.get(0).getY());
        segments.add(this);
    }

    public GraphicsGroup getSegmentsGroup() {
        return segments;
    }

    public void removeAll() {
        segments.removeAll();
    }
}
