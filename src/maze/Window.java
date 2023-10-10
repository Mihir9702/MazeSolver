package maze;

import javax.swing.JFrame;

public class Window {
  
  JFrame frame = new JFrame();
  private static final Window instance = new Window();
  
  Window() {
    if (instance == null) {
      new Window();
    }

  }

  protected void run() {
    frame.setTitle("Maze");
    frame.setSize(640, 480);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLayout(null);
  }
}
