import java.awt.Image;

public class Bird {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image img;
    private int velocityY = 0;
    private static final int JUMP_FORCE = -9;
    private static final int GRAVITY = 1;

    public Bird(int x, int y, int width, int height, Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }

    public void jump() {
        velocityY = JUMP_FORCE;
    }

    public void move(int boardHeight) {
        velocityY += GRAVITY;
        y += velocityY;
        y = Math.max(y, 0);
    }

    public void reset(int initialY) {
        y = initialY;
        velocityY = 0;
    }

    // Getter methods
    public int getX() { return x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public Image getImage() { return img; }
}