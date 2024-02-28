import java.util.Objects;
import java.util.Scanner;
public class Player {
    Scanner scanner = new Scanner(System.in);
    int turnLocation;
    public final String symbol;
    public int points;
    public Player(String symbol) {
        if (!(symbol.equals("X") || symbol.equals("O"))) {
            throw new IllegalArgumentException("Invalid Symbol: Must be X or O");
        }
        this.symbol = symbol;
        this.points = 0;
    }
    public Move getTurn() {
        System.out.println("Please make a move by inputting a positive whole number between 1 and 9");
        while(true) {
            turnLocation = scanner.nextInt();
            if (turnLocation >= 1 && turnLocation <= 9) {
                return new Move(this, turnLocation);
            } else {
                System.out.println("Please give a positive number between 1 and 9");
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return this.symbol.equals(player.symbol);
    }
    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}