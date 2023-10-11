package maze;

public class MazeSolver {

  private int[][] maze;
  private int rows, cols;

  public MazeSolver(int[][] maze) {
    this.maze = maze;
    this.rows = maze.length;
    this.cols = maze[0].length;
  }

  // Add methods to load the maze, check valid moves, mark visited cells, and print the maze.

  public int[][] printMaze() {
    int[][] maze = {
      { 1, 0, 3, 0, 0, 0 },
      { 0, 3, 0, 0, 0, 0 },
      { 0, 3, 0, 0, 3, 0 },
      { 0, 0, 0, 3, 0, 4 },
    };

    return maze;
  }

  // dfs
  public boolean solveMaze(int x, int y) {
    if (x < 0 || x >= rows || y < 0 || y >= cols || maze[0][0] != 1) {
      return false; // invalid move or blocked cell
    }

    maze[x][y] = 2; // mark cell as visited

    if (x == rows - 1 && y == cols - 1) {
      return true; // reached the end
    }

    if (
      solveMaze(x + 1, y) || // right
      solveMaze(x - 1, y) || // left
      solveMaze(x, y + 1) || // down
      solveMaze(x, y - 1) // up
    ) {
      return true;
    }

    maze[x][y] = 0; // unmark cell
    return false;
  }
}
