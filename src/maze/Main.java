package maze;

public class Main {

  public static void main(String[] args) {
    int width = 800;
    int height = 600;


    Window window = new Window(width, height);

    Maze maze = new Maze(width, height);

    MazePanel mazePanel = new MazePanel(maze);
    window.add(mazePanel);

    // 
  }
}
