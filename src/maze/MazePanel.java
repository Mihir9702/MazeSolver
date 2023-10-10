package maze;

import javax.swing.JPanel;
import java.awt.Graphics;

public class MazePanel extends JPanel {
    private Maze maze;

    public MazePanel(Maze maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        maze.drawGrid(g);
    }
}
