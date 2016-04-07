import org.junit.Assert;
import org.junit.Test;

public class TestGameLogic {
   @Test
    public void testprintUserField() throws Exception{
       GameLogic gameLogic= new GameLogic();
       Field field = new Field();
           field.setGride(1,1,Cell.mine);
           field.setGride(2,2,Cell.mine);
       gameLogic.setUserfield(field);
       Assert.assertEquals("unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \n" +
               "unknown unknown unknown clear unknown unknown unknown unknown unknown unknown \n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \n" +
               "unknown unknown unknown unknown unknown clear unknown unknown unknown unknown \n" +
               "unknown unknown clear unknown unknown unknown unknown unknown unknown unknown \n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown ",gameLogic.printUserField(););

   }
}
