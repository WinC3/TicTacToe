package src;

import javax.swing.JFrame;
import java.awt.Dimension;

public class GameWindow extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Board board;

    public GameWindow() {
        super("Tic Tac Toe");
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.board = new Board();
        gameWindow.add(gameWindow.board);
        gameWindow.board.repaint();

        gameWindow.pack();

    }
}