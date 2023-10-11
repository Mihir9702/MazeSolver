package maze;

import java.awt.Color;

public class Cell {

  public int x;
  public int y;
  public int width;
  public int height;
  public Color color;

  public Cell(int x, int y, int width, int height, Color color) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.color = color;
  }
}
