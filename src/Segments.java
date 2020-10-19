import java.util.List;
import java.util.concurrent.DelayQueue;

import edu.macalester.graphics.Point;

public class Segments extends Snake{

    private List<Point> path;
    private List<Point> newPath;
    private int distance;


    public Segments(Snake snake, List<Point> path, int distance) {
        super(snake.canvas);
        this.setFilled(true);
        this.path = path;
        this.distance = distance;
    }

    public void addToPaths(List<Point> newPath) {
        this.path = newPath;
    }

    public void follow(int seg) {
        if (seg > 0) {
            this.setPosition(path.get(this.path.size() - distance * 10).getX(), 
                                    path.get(this.path.size() - distance * 10).getY());
            path.remove(0);
        }
    }

    public void addToCanvas() {
        this.setCenter(path.get(0).getX(), path.get(0).getY());
        canvas.add(this);
    }
    
}
