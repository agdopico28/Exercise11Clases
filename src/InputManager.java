import java.util.Scanner;

public class InputManager {

    private Scanner input = new Scanner(System.in);

    public InputManager(){
        input = new Scanner(System.in);

    }
    public int enterCol() {
        System.out.println("Enter col: " );
        int col = input.nextInt();
        return col - 1;
    }

    public int enterRow() {
        System.out.println("Enter row: " );
        String text = input.next().toUpperCase();
        char letter = text.charAt(0);
        int row = letter - 'A';
        return row;
    }


}
