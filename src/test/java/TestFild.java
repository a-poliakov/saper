import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFild {
    Field field;

    @Before
    public void init() {
        // testConstructor();
        field = new Field();
    }

    @Test
    public void testConstructor() {
        assertNotNull("testConstructor failed", new Field());
    }

    @Test
    public void testCreateGrid() {
        Cell[][] grid = field.getGride();
        assertNotNull("grid is null", grid);
        for (Cell[] cellRow : grid) {
            for (Cell cell : cellRow) {
                assertEquals(Cell.unknown, cell);
            }
        }
    }

    @Test
    public void testRandom() {
        Cell[][] defoltGride = field.getGride();
       field.generateRandomField();
        Cell[][] randomGride = field.getGride();
        boolean isNotEquals = false;
        for (int i = 0; i < randomGride.length; i++) {
            for (int j = 0; j < randomGride[i].length; j++) {
                if (!randomGride[i][j].equals(defoltGride[i][j])) {
                    isNotEquals = true;
                }
            }

        }
        Assert.assertEquals(true,isNotEquals);

    }

}
