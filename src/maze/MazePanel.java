package maze;

import java.awt.Graphics;
import javax.swing.JPanel;

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
