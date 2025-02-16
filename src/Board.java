package src;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;

public class Board extends JPanel implements MouseListener {
    public static final int SIZE = 3;

    private char[][] board;
    private char currentPlayer;

    public Board() {
        board = new char[SIZE][SIZE];
        currentPlayer = 'X';
        addMouseListener(this);
    }

    protected void paintComponent(Graphics g) {
        System.out.println("Painting component");
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(0, GameWindow.HEIGHT / 3, GameWindow.WIDTH, GameWindow.HEIGHT / 3);
        g.drawLine(0, 2 * GameWindow.HEIGHT / 3, GameWindow.WIDTH, 2 * GameWindow.HEIGHT / 3); // Horizontal lines
        g.drawLine(GameWindow.WIDTH / 3, 0, GameWindow.WIDTH / 3, GameWindow.HEIGHT);
        g.drawLine(2 * GameWindow.WIDTH / 3, 0, 2 * GameWindow.WIDTH / 3, GameWindow.HEIGHT); // Vertical lines

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 'X') {
                    drawX(g, i, j);
                    System.out.println("Drawing X at " + i + ", " + j);
                } else if (board[i][j] == 'O') {
                    drawO(g, i, j);
                    System.out.println("Drawing O at " + i + ", " + j);
                }
            }
        }
    }

    private void drawX(Graphics g, int i, int j) {
        Point topLeft = new Point(i * GameWindow.WIDTH / SIZE, j * GameWindow.HEIGHT / SIZE);
        Point topRight = new Point((i + 1) * GameWindow.WIDTH / SIZE, j * GameWindow.HEIGHT / SIZE);
        Point bottomLeft = new Point(i * GameWindow.WIDTH / SIZE, (j + 1) * GameWindow.HEIGHT / SIZE);
        Point bottomRight = new Point((i + 1) * GameWindow.WIDTH / SIZE, (j + 1) * GameWindow.HEIGHT / SIZE);

        g.drawLine(topLeft.x, topLeft.y, bottomRight.x, bottomRight.y);
        g.drawLine(topRight.x, topRight.y, bottomLeft.x, bottomLeft.y);
    }

    private void drawO(Graphics g, int i, int j) {
        Point topLeft = new Point(i * GameWindow.WIDTH / SIZE + (int) (0.1 * GameWindow.WIDTH / SIZE),
                j * GameWindow.HEIGHT / SIZE + (int) (0.1 * GameWindow.HEIGHT / SIZE));
        Point bottomRight = new Point((i + 1) * GameWindow.WIDTH / SIZE - (int) (0.1 * GameWindow.WIDTH / SIZE),
                (j + 1) * GameWindow.HEIGHT / SIZE - (int) (0.1 * GameWindow.HEIGHT / SIZE));

        g.drawOval(topLeft.x, topLeft.y, bottomRight.x - topLeft.x, bottomRight.y - topLeft.y);
    }

    public void makeTurn(int x, int y) {
        x /= GameWindow.WIDTH / SIZE;
        y /= GameWindow.HEIGHT / SIZE;
        if (board[x][y] == '\0') {
            board[x][y] = currentPlayer == 'X' ? 'X' : 'O';
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
        makeTurn(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}