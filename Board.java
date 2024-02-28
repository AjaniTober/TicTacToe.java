public class Board {
    public String[] board = new String[9];
    public String[] newBoard = new String[9];
    public final String REDTEXT = "\u001B[91m";
    public final String WHITETEXT = "\u001B[97m";
    public final String BLUETEXT = "\u001B[94m";
    public Board() {
        for (int a = 0; a < 9; a++) {
            this.board[a] = String.valueOf(a + 1);
            this.newBoard[a] = String.valueOf(a + 1);
        }
    }
    public boolean isEmptyPosition(int pos) {
        return !board[pos].equals("X") && !board[pos].equals("O");
    }
    public void displayBoard() {
        System.out.println("|---|---|---|");
        System.out.printf("| %s | %s | %s | %n", newBoard[0], newBoard[1], newBoard[2]);
        System.out.println("|-----------|");
        System.out.printf("| %s | %s | %s | %n", newBoard[3], newBoard[4], newBoard[5]);
        System.out.println("|-----------|");
        System.out.printf("| %s | %s | %s | %n", newBoard[6], newBoard[7], newBoard[8]);
    }
    public String winner() {

        if (board[0].equals(board[1]) && board[1].equals(board[2])) {
            return board[0];
        } else if (board[3].equals(board[4]) && board[4].equals(board[5])) {
            return board[3];
        } else if (board[6].equals(board[7]) && board[7].equals(board[8])) {
            return board[6];
        }


        if
        (board[0].equals(board[3]) && board[3].equals(board[6])) {
            return board[0];
        } else if (board[1].equals(board[4]) && board[4].equals(board[7])) {
            return board[1];
        } else if (board[2].equals(board[5]) && board[5].equals(board[8])) {
            return board[2];
        }

        if (board[0].equals(board[4]) && board[4].equals(board[8])) {
            return board[0];
        } else if (board[2].equals(board[4]) && board[4].equals(board[6])) {
            return board[2];
        }
        for (String s : board) {
            if (!s.equals("X") && !s.equals("O")) {
                return null;
            }
        }
            return "draw";
    }
    public void applyMove(Move move) {
        board[move.pos - 1] =  move.player.symbol;
        if(move.player.symbol.equals("X")) {
            newBoard[move.pos - 1] = REDTEXT + move.player.symbol + WHITETEXT;
        } else {
            newBoard[move.pos - 1] = BLUETEXT + move.player.symbol + WHITETEXT;
        }
    }
}