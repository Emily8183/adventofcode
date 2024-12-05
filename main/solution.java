package main;
import main.day1.day1;
import main.day2.day2;
import main.day3.day3;
import main.day4.day4;

public class solution {
    public static void main(String[] args) {

        // day1 day1 = new day1();
        // String content = "main/day1/day1data.txt";
        // day1.day1solution(content);

        // day2 day2 = new day2();        
        // String content = "main/day2/day2extratest.txt";
        // int countResult = day2.countReport(content);
        // System.out.println(countResult);

        // day3 day3 = new day3();
        // String data = "main/day3/day3data.txt";
        // // String data = "main/day3/day3extratest.txt";
        // int result = day3.calMultiply(data);
        // System.out.println(result); //part 2 isn't correct yet!!!!!

        day4 day4 = new day4();
        String word = "XMAS";
        char[][] board = {
        {'M', 'M', 'M', 'S', 'X', 'X', 'M', 'A', 'S', 'M'},
        {'M', 'S', 'A', 'M', 'X', 'M', 'S', 'M', 'S', 'A'},
        {'A', 'M', 'X', 'S', 'X', 'M', 'A', 'A', 'M', 'M'},
        {'M', 'S', 'A', 'M', 'A', 'S', 'M', 'S', 'M', 'X'},
        {'X', 'M', 'A', 'S', 'A', 'M', 'X', 'A', 'M', 'M'},
        {'X', 'X', 'A', 'M', 'M', 'X', 'X', 'A', 'M', 'A'},
        {'S', 'M', 'S', 'M', 'S', 'A', 'S', 'X', 'S', 'S'},
        {'S', 'A', 'X', 'A', 'M', 'A', 'S', 'A', 'A', 'A'},
        {'M', 'A', 'M', 'M', 'M', 'X', 'M', 'M', 'M', 'M'},
        {'M', 'X', 'M', 'X', 'A', 'X', 'M', 'A', 'S', 'X'}
        };

        int result = day4.countFindings(0, 0, 0, word, board);
        System.out.println(result);

        
    }
    
}
