package main.day4;

public class day4 {
    int count = 0;

    public int countFindings(int i, int j, int index, String word, char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
            
                if (board[i][j] == word.charAt(0)) {
                    // if (
                    //     findXmas(i, j+1, 1, word, board, "RIGHT") ||
                    //     findXmas(i, j-1, 1, word, board, "LEFT") ||
                    //     findXmas(i-1, j, 1, word, board, "UP") ||
                    //     findXmas(i+1, j, 1, word, board, "DOWN") ||
                    //     findXmas(i-1, j-1, 1, word, board, "UPLEFT") ||
                    //     findXmas(i+1, j-1, 1, word, board, "DOWNLEFT") ||
                    //     findXmas(i-1, j+1, 1, word, board, "UPRIGHT") ||
                    //     findXmas(i+1, j+1, 1, word, board, "DOWNRIGHT")) {
                        count += findXmas(i, j + 1, 1, word, board, "RIGHT") ? 1 : 0;
                        count += findXmas(i, j - 1, 1, word, board, "LEFT") ? 1 : 0;
                        count += findXmas(i - 1, j, 1, word, board, "UP") ? 1 : 0;
                        count += findXmas(i + 1, j, 1, word, board, "DOWN") ? 1 : 0;
                        count += findXmas(i - 1, j - 1, 1, word, board, "UPLEFT") ? 1 : 0;
                        count += findXmas(i + 1, j - 1, 1, word, board, "DOWNLEFT") ? 1 : 0;
                        count += findXmas(i - 1, j + 1, 1, word, board, "UPRIGHT") ? 1 : 0;
                        count += findXmas(i + 1, j + 1, 1, word, board, "DOWNRIGHT") ? 1 : 0;
    
                }

            }
        }
        

        return count;
    }

    public boolean findXmas(int i, int j, int index, String word, char[][] board, String direction) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j]) return false;

        switch (direction) {
            case "RIGHT": return findXmas(i, j+1, index+1, word, board, "RIGHT");

            case "LEFT": return findXmas(i, j-1, index+1, word, board, "LEFT");

            case "UP": return findXmas(i-1, j, index+1, word, board, "UP");

            case "DOWN": return findXmas(i+1, j, index+1, word, board, "DOWN");

            case "UPLEFT": return findXmas(i-1, j-1, index+1, word, board, "UPLEFT");
            
            case "DOWNLEFT": return findXmas(i+1, j-1, index+1, word, board, "DOWNLEFT");

            case "UPRIGHT": return findXmas(i-1, j+1, index+1, word, board, "UPRIGHT");

            case "DOWNRIGHT": return findXmas(i+1, j+1, index+1, word, board, "DOWNRIGHT");

            default: return false;

        }

    }
    
}

