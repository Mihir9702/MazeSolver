package mazesolver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MazeSolver extends JFrame {

  private int[][] maze = {
    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    { 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
    { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 },
    { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
    { 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
    { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1 }, // (11, 8) t
    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
  };

  private final List<Integer> path = new ArrayList<Integer>();
  private int pathIndex;

  MazeSolver(int width, int height) {
    setTitle("Maze Solver");
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    DepthFirstSearch.searchPath(maze, 1, 1, path);
    pathIndex = path.size() - 2;
    System.out.println(path);
  }

  @Override
  public void paint(Graphics g) {

    g.translate(50, 50);

    for (int row = 0; row < maze.length; row++) {
      for (int col = 0; col < maze[row].length; col++) {
        Color color;
        switch (maze[row][col]) {
          case 1:
            color = Color.BLACK;
            break;
          case 9:
            color = Color.RED;
            break;
          default:
            color = Color.WHITE;
            break;
        }

        g.setColor(color);
        g.fillRect(col * 30, row * 30, 30, 30);
        g.setColor(Color.BLACK);
        g.drawRect(col * 30, row * 30, 30, 30);
      }
    }

    // draw path
    for (int p = 0; p < path.size(); p += 2) {
      int px = path.get(p);
      int py = path.get(p + 1);
      g.setColor(Color.GREEN);
      g.fillRect(px * 30, py * 30, 30, 30);
    }

    // draw current position
    int px = path.get(pathIndex);
    int py = path.get(pathIndex + 1);
    g.setColor(Color.BLUE);
    g.fillRect(px * 30, py * 30, 30, 30);
  }

  @Override
  protected void processKeyEvent(KeyEvent e) {
    if (e.getID() != KeyEvent.KEY_PRESSED) {
      return;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      pathIndex -= 2;
      if (pathIndex < 0) {
        pathIndex = 0;
      }
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      pathIndex += 2;
      if (pathIndex >= path.size()) {
        pathIndex = path.size() - 2;
      }
    }
    repaint();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        @Override
        public void run() {
          MazeSolver ms = new MazeSolver(640, 480);
          ms.setVisible(true);
        }
      }
    );
  }
}
