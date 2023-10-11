package maze;

import javax.swing.JFrame;

public class Window extends JFrame {

  Window(int width, int height) {
    setTitle("Maze Solver");
    setSize(width, height);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
  }
}
