
public class Collision {

    private Snake snake;

    private Food food;

    /**
     * 
     * Tests for distance between the snake and the food, returning true if the two are
     * close. Can add collisions for walls and passages to to other side of screen 
     * later.
     * 
     */

    public Collision (Snake snake, Food food) {

        this.snake = snake;
        this.food = food;
    }

    public boolean eatsFood() {
        if(Math.hypot(snake.getX() - food.getCenterX(), 
                    snake.getY() - food.getCenterY()) < 50) 
        {
            return true;
        }
        else {
            return false;
        }
    }
}
