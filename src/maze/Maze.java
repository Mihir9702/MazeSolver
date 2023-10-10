package maze;

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

    public List<Cell> generateGrid() {
        List<Cell> cells = new ArrayList<>();

        int cellSize = 20;

        for (int x = 0; x < width; x += cellSize) {
            for (int y = 0; y < height; y += cellSize) {
                Cell cell = new Cell(x, y, cellSize, cellSize);
                cells.add(cell);
            }
        }

        return cells;
    }

    public void drawGrid(Graphics g) {
        List<Cell> cells = generateGrid();
        for (Cell cell : cells) {
            g.drawRect(cell.x, cell.y, cell.width, cell.height);
        }
    }
}
