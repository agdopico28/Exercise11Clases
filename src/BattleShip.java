public class BattleShip {

    public static void main(String[] args) {
        boolean gameOver = false;
        int row, col;

        Board board = new Board();
        InputManager inputManager = new InputManager();

        while(! gameOver) {
            board.printStatistics();
            board.printBoard(false);
            row = inputManager.enterRow();
            col = inputManager.enterCol();
            board.shot(row,col);
            gameOver = board.checkGameOver();
        }
        System.out.println("------GAME OVER!!------");
        board.printStatistics();
        board.printBoard(true);


    }

}
