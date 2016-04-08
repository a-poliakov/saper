import java.util.Random;

public class Field {
    private Cell[][] grid;

    public Field() {
        grid = new Cell[10][10];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = Cell.unknown;
            }
        }
    }

    public Cell[][] getGrid() {
        Cell[][] tempGrid = new Cell[10][10];
        for (int i = 0; i < tempGrid.length; i++) {
            for (int j = 0; j < tempGrid[i].length; j++) {
                tempGrid[i][j] = grid[i][j];
            }
        }
        return tempGrid;
    }

    public void generateRandomField() {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (count >= 25) {
                break;
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (count >= 25) {
                    break;
                }
                grid[i][j] = Cell.mine;
                count++;
            }
        }
        count = 0;
        Random random = new Random();
        while (count < 1000) {
            int randomX1 = random.nextInt(10);
            int randomX2 = random.nextInt(10);
            int randomY1 = random.nextInt(10);
            int randomY2 = random.nextInt(10);
            Cell tempCell = grid[randomX1][randomY1];
            grid[randomX1][randomY1] = grid[randomX2][randomY2];
            grid[randomX2][randomY2] = tempCell;
            count++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == Cell.unknown)
                    grid[i][j] = Cell.clear;
            }
        }
    }

    public void setGride(int x, int y, Cell type) throws Exception {
        if (isCellNotInField(x, y)) {
            throw new Exception("Wrong set  coordinates");
        }
        grid[x][y] = type;
    }

    public Cell getCell(int x, int y) throws Exception {
        if (isCellNotInField(x, y)) {
            throw new Exception("Wrong get  coordinates");
        }
        return grid[x][y];
    }

    public Boolean isCellNotInField(int x, int y) {
        return x < 0 || x > 10 || y < 0 || y > 10;
    }
}