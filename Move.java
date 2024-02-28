public class Move {
    public final Player player;
    public final int pos;
    public Move(Player player, int pos) {
        if (!(pos >= 1 && pos <= 9)) {
            throw new IllegalArgumentException("Invalid Position: Must be 1-9");
        }
        this.player = player;
        this.pos = pos;
    }
}