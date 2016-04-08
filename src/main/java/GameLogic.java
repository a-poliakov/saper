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

    public void gameProccess() {
        int x;
        int y;
        while (countOfTurns < 10) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter the coordinates for the shot");
                x = scanner.nextInt();
                y = scanner.nextInt();
            } catch (Exception e) {
                continue;
            }
            try {
                if (userField.getCell(x, y) != Cell.unknown) {
                    System.out.println("you repeat yourself");
                    continue;
                }
                userField.setGride(x, y, nativeField.getCell(x, y));
                if (nativeField.getCell(x, y) == Cell.mine) {
                    System.out.println("GAME OVER....");
                    break;
                } else if (countOfTurns == 9) {
                    System.out.println("YOU WIN THE GAME!!!!!!!!!!!!!!!!!!!");
                    break;
                } else {
                    countOfTurns++;
                }
                printUserField(userField);
            } catch (Exception e) {
                System.out.println("Wrong coordinates! Try again!");
            }
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
}
