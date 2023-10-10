package maze;

import java.util.*;

public class Maze {
  
  final int width;
  final int height;

  List<Cell> cells = new ArrayList<>(null);

  Maze(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public void generate() {

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        Cell cell = new Cell(i * 50, j * 50);
        cells.add(cell);
      }
    }
  }

}
