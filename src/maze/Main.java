package maze;

public class Main {

  public static void main(String[] args) {
    // get maze

    MazeSolver mazeSolver = new MazeSolver(maze);

    if (mazeSolver.solveMaze(0, 0)) {
      mazeSolver.printMaze();
    } else {
      System.out.println("No solution");
    }
  }
}
