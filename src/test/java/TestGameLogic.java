import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class TestGameLogic {
   @Test
    public void testPrintUserField() throws Exception{
       GameLogic gameLogic = new GameLogic();
       Field field = new Field();
       field.setGride(1,1,Cell.mine);
       field.setGride(2, 2, Cell.mine);
       final StringBuilder output = new StringBuilder();
       System.setOut(new PrintStream(new OutputStream() {
           @Override
           public void write(int b) throws IOException {
               output.append((char) b);
           }
       }));
       gameLogic.printUserField(field);
       Assert.assertEquals("unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \r\n" +
               "unknown mine unknown unknown unknown unknown unknown unknown unknown unknown \r\n" +
               "unknown unknown mine unknown unknown unknown unknown unknown unknown unknown \r\n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \r\n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \r\n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \r\n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \r\n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \r\n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \r\n" +
               "unknown unknown unknown unknown unknown unknown unknown unknown unknown unknown \r\n", output.toString());

   }
}
