package maze;


public class Main {

  public static void main(String[] args) {
    Window window = new Window();
    window.run();

    Maze maze = new Maze(10, 10);
    maze.generate();
  }
}
