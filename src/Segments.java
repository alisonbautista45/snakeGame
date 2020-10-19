import java.util.List;
import java.util.concurrent.DelayQueue;

import edu.macalester.graphics.Point;

public class Segments extends Snake{

    private List<Point> path;
    private int distance;


    public Segments(Snake snake, List<Point> path, int distance) {
        super(snake.canvas);
        this.setFilled(true);
        this.path = path;
        this.distance = distance;
    }

    public void follow() {
        this.setPosition(path.get(this.path.size() - distance * 6).getX(), 
                                path.get(this.path.size() - distance * 6).getY());

    }

    public void addToCanvas() {
        this.setCenter(path.get(0).getX(), path.get(0).getY());
        canvas.add(this);
    }
    
}
