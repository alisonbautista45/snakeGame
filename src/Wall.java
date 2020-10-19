import edu.macalester.graphics.Rectangle;

import java.util.List;
import java.util.Random;

import java.awt.Color;

public class Wall extends Rectangle {

    public Wall(double x, double y, double width, double height) {
        super(x, y, width, height);

        Random random = new Random();
        List<Color> colors = List.of(Color.GREEN, Color.BLUE, Color.CYAN, Color.ORANGE, Color.MAGENTA, Color.YELLOW);
        this.setFilled(true);
        this.setFillColor(colors.get(random.nextInt(colors.size())));
        this.setStroked(true);
    }

}