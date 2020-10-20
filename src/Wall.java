import edu.macalester.graphics.Rectangle;

import java.util.List;
import java.util.Random;

import java.awt.Color;

public class Wall extends Rectangle {

    public static final Color YELLOW = new Color(238, 186, 76);
    public static final Color RED = new Color(227, 73, 59);
    public static final Color AQUA = new Color(35, 181, 175);
    public static final Color LIGHT_AQUA = new Color(169, 221, 217);
    public static final Color DARK_GREAY = new Color(58, 58, 60);

    public Wall(double x, double y, double width, double height) {
        super(x, y, width, height);

        Random random = new Random();
        List<Color> colors = List.of(YELLOW, RED, AQUA, LIGHT_AQUA);
        this.setFilled(true);
        this.setFillColor(colors.get(random.nextInt(colors.size())));
        this.setStroked(true);
    }
    
}