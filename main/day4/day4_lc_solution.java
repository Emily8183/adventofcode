package main.day4;

//This is the function to calculate all the possibilities, so the word "XMAS" could turn. The codes run fine but the solution does NOT meet the problem's requirements

public class day4_lc_solution {

    boolean visited[][];
    int count = 0;

    public int countFindings(int i, int j, int index, String word, char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        
        visited = new boolean[rows][columns];

        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
            
                if (findXmas(i, j, 0, word, board)) {
                    
                    count++;
                }
                clearVisited();
            }
        }

        return count;
    }

    public boolean findXmas(int i, int j, int index, String word, char[][] board) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j] || visited[i][j]) return false;

        visited[i][j] = true;

        if (findXmas(i+1, j, index+1, word, board) || //往下
            findXmas(i-1, j, index+1, word, board) || //往上

            findXmas(i-1, j+1, index+1, word, board) || //往右上
            findXmas(i+1, j+1, index+1, word, board) || //往右下
            
            findXmas(i-1, j-1, index+1, word, board) || //往左上            
            findXmas(i+1, j-1, index+1, word, board) || //往左下

            findXmas(i, j-1, index+1, word, board) || //往左
            findXmas(i, j+1, index+1, word, board)) { //往右
                
            return true;
        }

        visited[i][j] = false;

        return false;

    }

    private void clearVisited() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }
    
}
