public class Board {
    public static final char SHIP_SYMBOL = 'S';
    public static final char EMPTY_SYMBOL = '-';
    public static final char WATER_SYMBOL = 'O';
    public static final char SUNK_SHIP_SYMBOL = 'X';
    public static final int NUM_ROWS = 8;
    public static final int NUM_COLS = 8;
    public static final int NUM_SHIPS = 10;
    static char[][] board = new char[NUM_ROWS][NUM_COLS];
    private int numShots = 0;
    private int sunkShip = 0;

    public Board() {
        initBoard();
        addShips();
    }

    public void initBoard(){
        for(int rows = 0; rows < board.length; rows++){
            for (int cols = 0; cols < board[0].length; cols++) {
                board[rows][cols] = '-';

            }
        }
    }

    private void addShips(){
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

    public void printBoard(boolean showShips){
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

    public void shot(int row, int col) {
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

    public boolean checkGameOver() {
        return sunkShip == NUM_SHIPS;
        /* if (sunkShip == NUM_SHIPS){
           return true;
        }else {
            return false;
        } */
    }

    public void printStatistics() {
        System.out.println("Shots: " + numShots);
        System.out.println("Sunk Ships: " + sunkShip);

    }
}
