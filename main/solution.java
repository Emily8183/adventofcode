package main;
import java.io.IOException;

import main.day1.day1;
import main.day2.day2;
import main.day3.day3;
import main.day4.day4_convertdata;

public class solution {
    public static void main(String[] args) throws IOException {

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

        day4_convertdata day4_convertdata = new day4_convertdata();
        // String word = "XMAS";
        String board = "main/day4/day4data.txt";
        int countResult = day4_convertdata.countFindings(0, 0, 0, "XMAS", board);
        System.out.println(countResult);

        
    }
    
}
