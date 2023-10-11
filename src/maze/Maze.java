package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Maze {

  private final int width;
  private final int height;

  Maze(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public Cell[][] generateGrid() {
    int cellSize = 20;

    Cell[][] cells = new Cell[width / cellSize][height / cellSize];

    for (int x = 0; x < width; x += cellSize) {
      for (int y = 0; y < height; y += cellSize) {
        if (x == 0 && y == 0) {
          Cell cell = new Cell(x, y, cellSize, cellSize, Color.RED);
          cells[0][0] = cell;
          continue;
        }

        Cell cell = new Cell(x, y, cellSize, cellSize, Color.GRAY);
        cells[x][y] = cell;
      }
    }

    return cells;
  }

  public void drawGrid(Graphics g) {
    Cell[][] cells = generateGrid();
    for (Cell[] cellar : cells) {
      for (Cell cell : cellar) {
        g.fillRect(cell.x, cell.y, cell.width, cell.height);
      }
    }
  }
}
