import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
public class GameState {
    public Player[] players;
    public Board board;
    public Player currentPlayer;
    public GameState() {
        this.players = new Player[2];
        this.players[0] = new Player("X");
        this.players[1] = new Player("O");
        this.board = new Board();
        this.currentPlayer = this.randomPlayer();
    }
    public Player randomPlayer() {
        return this.players[new Random().nextBoolean() ? 0 : 1];
    }
    public void newGame() {
        this.board = new Board();
        this.currentPlayer = this.randomPlayer();
    }
    public void addPointToWinningPlayer() {
        String winner = this.board.winner();
        if (!(winner == null || winner.equals("draw"))) {
            Optional<Player> player = Arrays
                    .stream(this.players)
                    .filter(p -> p.symbol.equals(winner))
                    .findFirst();
            if (player.isPresent()) {
                int idx = Arrays.asList(this.players).indexOf(player.get());
                this.players[idx].points++;
            } else {
                throw new RuntimeException("Error: Couldn't find winning player");
            }
        }
    }
    public void nextPlayer() {
        if (this.currentPlayer.equals(this.players[0])) {
            this.currentPlayer = this.players[1];
        } else {
            this.currentPlayer = this.players[0];
        }
    }
    public boolean isOver() {
        return this.board.winner() != null;
    }
}