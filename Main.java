import java.util.Scanner;
public class Main {
    static GameState game = new GameState();
    public static void main(String[] args) {
        while (true) {
            while (!game.isOver()) {
                game.board.displayBoard();
                Move turn = game.currentPlayer.getTurn();
                while(!game.board.isEmptyPosition(turn.pos-1)){
                    System.out.println("This position is already taken");
                    turn = game.currentPlayer.getTurn();
                }
                game.board.applyMove(turn);
                game.nextPlayer();
            }
            String continuePlaying = "";
            Scanner scanner = new Scanner(System.in);
            game.board.displayBoard();
            game.board.winner();
            System.out.print(game.board.winner());
            System.out.println("\n Would you like to play again?");
            continuePlaying = scanner.next();
            if (continuePlaying.equals("yes")){
                game.newGame();
            } else {
                break;
            }
        }
    }
}