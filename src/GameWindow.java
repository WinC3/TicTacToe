package src;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class GameWindow extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Board board;
    private InfoPanel infoPanel;

    public GameWindow() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(new Dimension(WIDTH, HEIGHT));
    }

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.board = new Board();
        gameWindow.board.repaint();
        gameWindow.infoPanel = new InfoPanel();

        gameWindow.setLayout(new BorderLayout());
        gameWindow.add(gameWindow.board, BorderLayout.NORTH);
        gameWindow.add(gameWindow.infoPanel, BorderLayout.SOUTH);
        gameWindow.pack();

        while (true) {
            gameWindow.infoPanel.setCurrentPlayer(gameWindow.board.getCurrentPlayer());
            if (gameWindow.board.checkWin() != '\0') {
                gameWindow.infoPanel.setWinner(gameWindow.board.checkWin());
                break;
            }
        }
        gameWindow.board.removeMouseListener(gameWindow.board);

    }
}