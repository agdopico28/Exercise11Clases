import java.sql.SQLOutput;
import java.util.Scanner;

public class Exercise11 {
    public static final char SHIP_SYMBOL = 'S';
    public static final char EMPTY_SYMBOL = '-';
    public static final char WATER_SYMBOL = 'O';
    public static final char SUNK_SHIP_SYMBOL = 'X';
    public static final int NUM_ROWS = 8;
    public static final int NUM_COLS = 8;
    public static final int NUM_SHIPS = 10;
    private static boolean gameOver = false;
    private static int numShots = 0;
    private static int sunkShip = 0;
    static char[][] board = new char[NUM_ROWS][NUM_COLS];
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int shots = 0, ships = 0;
        int row, col;
        initBoard();
        addShips();

        while(! gameOver) {
            printStatistics();
            printBoard(false);
            row = enterRow();

            col = enterCol();
            shot(row,col);
            checkGameOver();
        }
        System.out.println("------GAME OVER!!------");
        printStatistics();
        printBoard(true);


    }

    private static void checkGameOver() {
        if (sunkShip == NUM_SHIPS){
            gameOver = true;
        }
    }

    private static void shot(int row, int col) {
        if ( board[row][col] == SHIP_SYMBOL){
            board[row][col]= SUNK_SHIP_SYMBOL;
            numShots++;
            sunkShip++;
        }else {
            if(board[row][col] != SUNK_SHIP_SYMBOL){
                board[row][col] = WATER_SYMBOL;
                numShots++;
            }

        }

    }

    private static int enterCol() {
        System.out.println("Enter col: " );
        int col = input.nextInt();
        return col - 1;
    }

    private static int enterRow() {
        System.out.println("Enter row: " );
        String text = input.next().toUpperCase();
        char letter = text.charAt(0);
        int row = letter - 'A';
        return row;
    }

    private static void printStatistics() {
        System.out.println("Shots: " + numShots);
        System.out.println("Sunk Ships: " + sunkShip);

    }

    private static void initBoard(){
        for(int rows = 0; rows < board.length; rows++){
            for (int cols = 0; cols < board[0].length; cols++) {
                board[rows][cols] = '-';

            }
        }
    }
    private static void printBoard(boolean showShips){
        char letter = 'A';
        int number = 1;


        System.out.print("  ");
        for (int col = 0; col < board[0].length; col++) {
            System.out.print(number + " ");
            number++;
        }
        System.out.println();

        for(int row = 0; row < board.length; row++){
            System.out.print(letter + " ");
            letter++;
            for (int col = 0; col < board[0].length; col++) {
                if (!showShips && board[row][col] == SHIP_SYMBOL){
                    System.out.print(EMPTY_SYMBOL + " ");
                }else{
                    System.out.print(board[row][col] + " ");
                }


            }

            System.out.println();
        }


    }
    private static void addShips(){
        int contBoard= 0;
        int row, col;
        while(contBoard < NUM_SHIPS){
            row = (int) (Math.random() * NUM_ROWS);
            col = (int) (Math.random() * NUM_COLS);
            if(board[row][col] != SHIP_SYMBOL){
                board[row][col] = SHIP_SYMBOL;
                contBoard++;
            }

        }

    }
    private static void shotShips(){

    }
}
