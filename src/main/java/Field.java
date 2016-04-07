import java.util.Random;

public class Field {
    private Cell[][] gride;

    public Field() {
        gride = new Cell[10][10];
        for (int i = 0; i < gride.length; i++) {
            for (int j = 0; j < gride[i].length; j++) {
                gride[i][j] = Cell.unknown;
            }
        }
    }

//    public Cell[][] getGride() {
//     return cloneGride();
//    }

    public Cell[][] getGride() {
        Cell[][] tempGride = new Cell[10][10];
        for (int i = 0; i < tempGride.length; i++) {
            for (int j = 0; j < tempGride[i].length; j++) {
                tempGride[i][j] = gride[i][j];
            }
        }
        return tempGride;
    }

    public void generateRandomField() {
        int count = 0;
        for (int i = 0; i < gride.length; i++) {
            if (count >= 25) {
                break;
            }
            for (int j = 0; j < gride[i].length; j++) {
                if (count >= 25) {
                    break;
                }
                gride[i][j] = Cell.mine;
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
            Cell tempCell = gride[randomX1][randomY1];
            gride[randomX1][randomY1] = gride[randomX2][randomY2];
            gride[randomX2][randomY2] = tempCell;
            count++;
        }
        for (int i = 0; i < gride.length; i++) {
            for (int j = 0; j < gride[i].length; j++) {
                if (gride[i][j] == Cell.unknown)
                    gride[i][j] = Cell.clear;
            }
        }
    }

    public void setGride(int x, int y, Cell type) throws Exception {
        if (isCellNotInField(x, y)) {
            throw new Exception("Wrong set  coordinates");
        }
        gride[x][y] = type;
    }

    public Cell getCell(int x, int y) throws Exception {
        if (isCellNotInField(x, y)) {
            throw new Exception("Wrong get  coordinates");
        }
        return gride[x][y];
    }

    public Boolean isCellNotInField(int x, int y) {
        return x < 0 || x > 10 || y < 0 || y > 10;
    }

}