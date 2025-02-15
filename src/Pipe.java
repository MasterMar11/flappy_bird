import java.awt.Image;

public class Pipe {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image img;
    private boolean passed;

    public Pipe(int x, int y, int width, int height, Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
        this.passed = false;
    }

    public void move(int velocityX) {
        x += velocityX;
    }

    public boolean checkCollision(Bird bird) {
        return bird.getX() < x + width &&
                bird.getX() + bird.getWidth() > x &&
                bird.getY() < y + height &&
                bird.getY() + bird.getHeight() > y;
    }

    // Getter and setter methods
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public Image getImage() { return img; }
    public boolean isPassed() { return passed; }
    public void setPassed(boolean passed) { this.passed = passed; }
}