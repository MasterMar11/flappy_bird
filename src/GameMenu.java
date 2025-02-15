import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMenu extends JPanel {
    private String selectedBackground = "default";
    private String selectedBird = "default";
    private boolean menuClosed = false;
    private GameBoard gameBoard;

    public GameMenu() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1920, 1080));

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridLayout(6, 1, 10, 10));
        selectionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Flappy Bird Settings", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel bgLabel = new JLabel("Select Background:", SwingConstants.CENTER);
        JComboBox<String> backgroundSelector = new JComboBox<>(new String[]{
                "Default", "Night", "Desert", "Snow"
        });

        JLabel birdLabel = new JLabel("Select Bird:", SwingConstants.CENTER);
        JComboBox<String> birdSelector = new JComboBox<>(new String[]{
                "Default", "Blue", "Red", "Green"
        });

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> {
            selectedBackground = backgroundSelector.getSelectedItem().toString().toLowerCase();
            selectedBird = birdSelector.getSelectedItem().toString().toLowerCase();
            menuClosed = true;
            gameBoard = new GameBoard(selectedBackground, selectedBird);

            // Replace menu with game board
            Container parent = getParent();
            parent.remove(this);
            parent.add(gameBoard);
            parent.revalidate();
            parent.repaint();
            gameBoard.requestFocus();
        });

        selectionPanel.add(title);
        selectionPanel.add(bgLabel);
        selectionPanel.add(backgroundSelector);
        selectionPanel.add(birdLabel);
        selectionPanel.add(birdSelector);
        selectionPanel.add(startButton);

        add(selectionPanel, BorderLayout.CENTER);
    }
}
