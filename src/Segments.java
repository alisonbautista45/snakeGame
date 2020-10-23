import java.util.List;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;

public class Segments extends Rectangle {

    private List<Point> path;
    private int distance;
    private static GraphicsGroup segments = new GraphicsGroup();

    public Segments(Snake snake, List<Point> path, int distance) {
        super(0, 0, 10, 10);
        this.setFilled(true);
        this.setFillColor(SnakeGame.DARK_GREEN);
        this.setStrokeColor(Color.BLACK);
        this.setStrokeWidth(0.4);
        this.path = path;
        this.distance = distance;
    }

    public void follow() {
        this.setPosition(path.get(this.path.size() - distance * 6).getX() + 2.5,
            path.get(this.path.size() - distance * 6).getY() + 2.5);
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
