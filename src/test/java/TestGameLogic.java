import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class TestGameLogic {
    final StringBuilder output = new StringBuilder();
    final StringBuilder input = new StringBuilder();

    @Before
    public void initAll() {
        System.setIn(new InputStream() {
            int position = 0;

            @Override
            public int read() throws IOException {
                if (position >= input.toString().length()) {
                    return -1;
                }
                int currentChar = input.toString().charAt(position);
                position++;
                if((char)currentChar == '\n'){
                    return -1;
                }
                return currentChar;
            }
        });
    }


    @Test
    public void testPrintUserField() throws Exception {
        GameLogic gameLogic = new GameLogic();
        Field field = new Field();
        field.setGride(1, 1, Cell.mine);
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

    @Test
    public void testGameProccess() throws Exception {
        Class gameLogicClass = GameLogic.class;
        Method setNativeField = gameLogicClass.getDeclaredMethod("setNativeField", Field.class);
        setNativeField.setAccessible(true);
        GameLogic gameLogic = (GameLogic) gameLogicClass.newInstance();
        Field field = new Field();
        field.setGride(0, 0, Cell.clear);
        for (int i = 0; i < 10; i++) {
            field.setGride(1, i, Cell.clear);
            input.append("1 " + i + " \n");
        }
        setNativeField.invoke(gameLogic, field);
        input.append("0 0 \n");
        /*for (int i=0;i<10;i++){
           gameLogic.processUserInput(1,i);
        }*/
        Assert.assertTrue(gameLogic.gameProccess());
    }

    @Test
    public void testGameTurn() throws Exception {
        Class gameLogicClass = GameLogic.class;
        Method setNativeField = gameLogicClass.getDeclaredMethod("setNativeField", Field.class);
        setNativeField.setAccessible(true);
        GameLogic gameLogic = (GameLogic) gameLogicClass.newInstance();
        Field field = new Field();
        field.setGride(1, 2, Cell.clear);
        field.setGride(1, 1, Cell.mine);
        setNativeField.invoke(gameLogic, field);
        input.append("1 2");
        Assert.assertTrue(gameLogic.gameTurn());
//        input.delete(0,2);
        input.append("1 1");
        Assert.assertFalse(gameLogic.gameTurn());

    }

    @Test
    public void testPlayerInput() throws Exception {
        input.append("1 1");
        GameLogic gameLogic = new GameLogic();
        int[] expectide = {1, 1};
        int[] userIntput = gameLogic.playerInput();
        Assert.assertArrayEquals(expectide, userIntput);
//        input.delete(0, 2);
        input.append(". 1");
        userIntput = gameLogic.playerInput();
        Assert.assertArrayEquals(null, userIntput);
    }

    @Test
    public void testProcessUserInput() throws Exception {
        Class gameLogicClass = GameLogic.class;
        Method setNativeField = gameLogicClass.getDeclaredMethod("setNativeField", Field.class);
        setNativeField.setAccessible(true);
        GameLogic gameLogic = (GameLogic) gameLogicClass.newInstance();
        Field field = new Field();
        field.setGride(1, 2, Cell.clear);
        field.setGride(1, 1, Cell.mine);
        setNativeField.invoke(gameLogic, field);
        Assert.assertTrue(gameLogic.processUserInput(1, 2));
        Assert.assertFalse(gameLogic.processUserInput(1, 1));
    }
}