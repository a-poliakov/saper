import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLogic {
    private Field userfield;
    private Field nativeField;
    private int countNumberOfTerns;

    public GameLogic() {
        userfield = new Field();
        nativeField = new Field();
        nativeField.generateRandomField();
    }

    public Field getUserfield() {
        return userfield;
    }

    public void setUserfield(Field userfield) {
        this.userfield = userfield;
    }

    public static void main(String[] args) {
        new GameLogic().gameProccess();

    }

    public void gameProccess() {


        int x ;
        int y ;
        while (countNumberOfTerns < 10) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter the coordinates for the shot");
                x = scanner.nextInt();
                y = scanner.nextInt();
            } catch (InputMismatchException ex) {
                ex.printStackTrace();
                continue;
            } catch (Exception e) {
                continue;
            }
            try {
                if (userfield.getCell(x, y) != Cell.unknown) {
                    System.out.println("you repeat yourself");
                    continue;
                }
                userfield.setGride(x, y, nativeField.getCell(x, y));

                if (nativeField.getCell(x, y) == Cell.mine) {
                    System.out.println("GAME OVER....");
                    printUserField();
                    break;
                } else if (countNumberOfTerns == 9) {
                    System.out.println("YOU WIN THE GAME!!!!!!!!!!!!!!!!!!!");
                    printUserField();
                    break;
                } else {
                    countNumberOfTerns++;
                    printUserField();
                }
            } catch (Exception e) {
                System.out.println("Введенны неправильные коардинаты , попробуте еще раз");
            }
        }
    }

    public void printUserField() {
        for (int i = 0; i < userfield.getGride().length; i++) {
            for (int j = 0; j < userfield.getGride()[i].length; j++) {
                System.out.print(userfield.getGride()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
