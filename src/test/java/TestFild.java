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
        Cell[][] grid = field.getGrid();
        assertNotNull("grid is null", grid);
        for (Cell[] cellRow : grid) {
            for (Cell cell : cellRow) {
                assertEquals(Cell.unknown, cell);
            }
        }
    }

    @Test
    public void testRandom() {
        Cell[][] defoltGride = field.getGrid();
        field.generateRandomField();
        Cell[][] randomGride = field.getGrid();
        boolean isNotEquals = false;
        for (int i = 0; i < randomGride.length; i++) {
            for (int j = 0; j < randomGride[i].length; j++) {
                if (!randomGride[i][j].equals(defoltGride[i][j])) {
                    isNotEquals = true;
                }
            }
        }
        Assert.assertEquals(true, isNotEquals);
    }

    @Test
    public void testGetGride() {
        Assert.assertNotNull(field.getGrid());
    }

    @Test(expected = Exception.class)
    public void testSetGideExeption() throws Exception {
        field.setGride(11, 1, Cell.mine);
        Assert.assertEquals(Cell.mine, field.getGrid()[1][1]);
    }

    @Test
    public void testSetGide() throws Exception {
        field.setGride(1, 1, Cell.mine);
        Assert.assertEquals(Cell.mine, field.getGrid()[1][1]);
    }

    @Test(expected = Exception.class)
    public void testGetGideExeption() throws Exception {
        field.getCell(11, 1);
    }

    @Test
    public void testGetGide() throws Exception {
        testSetGide();
        Assert.assertEquals(Cell.mine, field.getCell(1, 1));
    }

    @Test
    public void testisCellNotInField(){
        Assert.assertEquals(field.isCellNotInField(1,1),false);
        Assert.assertEquals(field.isCellNotInField(1,11),true);
    }
}