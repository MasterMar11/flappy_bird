import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends JPanel implements ActionListener, KeyListener {
    private static final int BOARD_WIDTH = 1920;
    private static final int BOARD_HEIGHT = 1080;
    private static final int VELOCITY_X = -4;

    private Bird bird;
    private ArrayList<Pipe> pipes;
    private Timer gameLoop;
    private Timer placePipeTimer;
    private boolean gameOver;
    private double score;

    private Image backgroundImg;
    private Image birdImg;
    private Image topPipeImg;
    private Image bottomPipeImg;
    private String backgroundType;
    private String birdType;

    public GameBoard(String backgroundType, String birdType) {
        this.backgroundType = backgroundType;
        this.birdType = birdType;

        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setFocusable(true);
        addKeyListener(this);

        loadImages();
        initializeGame();
    }

    private void loadImages() {
        // Load background based on selection
        String bgPath = switch (backgroundType) {
            case "night" -> "./flappybirdbg_night.png";
            case "desert" -> "./flappybirdbg_desert.png";
            case "snow" -> "./flappybirdbg_snow.png";
            default -> "./flappybirdbg.png";
        };

        // Load bird based on selection
        String birdPath = switch (birdType) {
            case "blue" -> "./flappybird_blue.png";
            case "red" -> "./flappybird_red.png";
            case "green" -> "./flappybird_green.png";
            default -> "./flappybird.png";
        };

        backgroundImg = new ImageIcon(getClass().getResource(bgPath)).getImage();
        birdImg = new ImageIcon(getClass().getResource(birdPath)).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();
    }

    private void initializeGame() {
        bird = new Bird(BOARD_WIDTH/8, BOARD_WIDTH/2, 80, 70, birdImg);
        pipes = new ArrayList<>();
        gameOver = false;
        score = 0;

        placePipeTimer = new Timer(2000, e -> placePipes());
        placePipeTimer.start();

        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
    }

    private void placePipes() {
        int pipeHeight = 512;
        int pipeY = 0;
        int randomPipeY = (int) (pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2));
        int openingSpace = BOARD_HEIGHT/4;

        Pipe topPipe = new Pipe(BOARD_WIDTH, randomPipeY, 200, pipeHeight, topPipeImg);
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(BOARD_WIDTH, randomPipeY + pipeHeight + openingSpace,
                200, pipeHeight, bottomPipeImg);
        pipes.add(bottomPipe);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, BOARD_WIDTH, BOARD_HEIGHT, null);
        g.drawImage(bird.getImage(), bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight(), null);

        for (Pipe pipe : pipes) {
            g.drawImage(pipe.getImage(), pipe.getX(), pipe.getY(), pipe.getWidth(), pipe.getHeight(), null);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if (gameOver) {
            g.drawString("Game Over: " + String.valueOf((int) score), 10, 35);
        } else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }

    private void update() {
        if (gameOver) return;

        bird.move(BOARD_HEIGHT);

        for (Pipe pipe : pipes) {
            pipe.move(VELOCITY_X);

            if (!pipe.isPassed() && bird.getX() > pipe.getX() + pipe.getWidth()) {
                score += 0.5;
                pipe.setPassed(true);
            }

            if (pipe.checkCollision(bird)) {
                gameOver = true;
            }
        }

        if (bird.getY() > BOARD_HEIGHT) {
            gameOver = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
        if (gameOver) {
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!gameOver) {
                bird.jump();
            } else {
                resetGame();
            }
        }
    }

    private void resetGame() {
        bird.reset(BOARD_WIDTH/2);
        pipes.clear();
        gameOver = false;
        score = 0;
        gameLoop.start();
        placePipeTimer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}