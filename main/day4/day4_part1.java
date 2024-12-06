//Part I

package main.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day4_part1 {

    int count = 0;

    public int countFindings(int i, int j, int index, String word, String content) throws IOException {

        char[][] board = convertFiletoBoard(content);

        int rows = board.length;
        int columns = board[0].length;

        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
            
                if (board[i][j] == word.charAt(0)) {
                    //index starts with 1 becuz we already checked the first index by the above line
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

    private char[][] convertFiletoBoard(String filePath) throws IOException {
        //create rows (ArrayList<>())
        List<char[]> rows = new ArrayList<>();

        //read the file, add the rows
        try (BufferedReader readData = new BufferedReader(new FileReader(filePath))) {
            String line;

            while((line = readData.readLine()) != null) {
                rows.add(line.toCharArray());
            }
        }

        //make the board 
        char[][] board = new char[rows.size()][];
        
        for (int i = 0; i < rows.size(); i++) {
            board[i] = rows.get(i);
        }

        return board;
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
