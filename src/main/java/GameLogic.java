import java.util.Scanner;

public class GameLogic {
    private Field userField;
    private Field nativeField;
    private int countOfTurns;

    public GameLogic() {
        userField = new Field();
        nativeField = new Field();
        nativeField.generateRandomField();
    }

    public static void main(String[] args) {
        new GameLogic().gameProccess();
    }

    public boolean gameProccess() {
        while (countOfTurns < 10) {
            if (gameTurn() == false) {
                break;
            }
        }
        return  true;
    }

    public Boolean gameTurn() {
        int[] coordinates = playerInput();
        if (coordinates == null) {
            return true;
        }
        return processUserInput(coordinates[0], coordinates[1]);
    }

    public int[] playerInput() {
        int[] coordinates = new int[2];
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the coordinates for the shot");
            coordinates[0] = scanner.nextInt();
            coordinates[1] = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong Scaner  coordinates! Try again!");
            return null;
        }
        return coordinates;
    }

    public Boolean processUserInput(int x, int y) {
        try {
            if (userField.getCell(x, y) != Cell.unknown) {
                System.out.println("you repeat yourself");
                return true;
            }
            userField.setGride(x, y, nativeField.getCell(x, y));
            if (nativeField.getCell(x, y) == Cell.mine) {
                System.out.println("GAME OVER....");
                return false;
            } else if (countOfTurns == 9) {
                System.out.println("YOU WIN THE GAME!!!!!!!!!!!!!!!!!!!");
                return false;
            } else {
                countOfTurns++;
            }
            printUserField(userField);
            return true;
        } catch (Exception e) {
            System.out.println("Wrong fields  coordinates! Try again!");
            return true;
        }
    }

    public void printUserField(Field fieldForPrint) {
        for (int i = 0; i < fieldForPrint.getGrid().length; i++) {
            for (int j = 0; j < fieldForPrint.getGrid()[i].length; j++) {
                System.out.print(fieldForPrint.getGrid()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setNativeField(Field field){
        nativeField  = field;
    }
}
