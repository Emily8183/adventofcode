//1) check four corners around "A", if found 2 M and 2 S, recursive; otherwise false;
//2) Recursion: 如果M == board[i][j] && S == board[i][j], row是否一致; 
// 或者纵坐标是否一致

package main.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day4_part2 {
    int count = 0;

    public int countMas(int i, int j, int index, String word, String content) throws IOException {

        char[][] board = convertFiletoBoard(content);

        int rows = board.length;
        int columns = board[0].length;

        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                if (board[i][j] == word.charAt(1) && findWord(i, j, 1, word, board)) {
                    count++;

                }

            }
        }
            return count;
    }

    private boolean findWord(int i, int j, int index, String word, char[][]board) {
           // 确保中心是A
           if (board[i][j] != 'A') return false;

           if (i < 1 || i >= board.length-1 || j < 1 || j >= board[i].length-1) return false;

           int upleft = board[i-1][j-1];
           int upright = board[i-1][j+1];
           int downleft = board[i+1][j-1];
           int downright = board[i+1][j+1];

           return (upleft + downright == 'M' + 'S') && (upright + downleft == 'M' + 'S');
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

    
}
