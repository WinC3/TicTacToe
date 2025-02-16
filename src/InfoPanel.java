package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
    char winner = '\0';
    char currentPlayer = 'X';

    public InfoPanel() {
        super();
        setPreferredSize(new Dimension(GameWindow.WIDTH, (int) (GameWindow.HEIGHT * 0.1)));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        if (winner == '\0') {
            g.drawString("Current player: " + currentPlayer, 10, 10);
        } else {
            g.drawString("Winner: " + winner, 10, 10);
        }
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
        repaint();
    }

    public void setWinner(char winner) {
        this.winner = winner;
        repaint();
    }

}
