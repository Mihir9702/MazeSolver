package mazesolver;

import java.util.List;

public class DepthFirstSearch {

  // if path is found this method returns true
  // path: { xn, yb, ... x-1, y-1, x0, y0 }
  // order is from end to start (reverse)
  public static boolean searchPath(
    int[][] maze,
    int x,
    int y,
    List<Integer> path
  ) {
    // 0 - not-visited
    // 2 - visited

    if (maze[y][x] == 9) {
      path.add(x);
      path.add(y);
      return true;
    }

    if (maze[y][x] == 0) {
      maze[y][x] = 2;

      int dx = -1;
      int dy = 0;
      if (searchPath(maze, x + dx, y + dy, path)) {
        path.add(x);
        path.add(y);
        return true;
      }

      dx = 1;
      dy = 0;
      if (searchPath(maze, x + dx, y + dy, path)) {
        path.add(x);
        path.add(y);
        return true;
      }

      dx = 0;
      dy = -1;
      if (searchPath(maze, x + dx, y + dy, path)) {
        path.add(x);
        path.add(y);
        return true;
      }

      dx = 0;
      dy = 1;
      if (searchPath(maze, x + dx, y + dy, path)) {
        path.add(x);
        path.add(y);
        return true;
      }
    }

    return false;
  }
}
