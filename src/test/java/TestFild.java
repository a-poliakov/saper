import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFild{
    Field field;

    @Before
    public void init(){
       // testConstructor();
        field = new Field();
    }

    @Test
    public void testConstructor(){
        Cell[][] grid = field.getGride();
        Assert.assertNotNull("grid is null", grid);
        for (Cell[] cellRow : grid) {
            for (Cell cell : cellRow) {
                Assert.assertEquals(Cell.unknown, cell);
            }
        }
        Assert.assertNotNull("testConstructor failed", new Field());
    }

    @Test
    public void testCreateGrid(){
        Cell[][] grid = field.getGride();
        Assert.assertNotNull("grid is null", grid);
        for (Cell[] cellRow : grid) {
            for (Cell cell : cellRow) {
                Assert.assertEquals(Cell.mine, cell);
            }
        }
    }
}
