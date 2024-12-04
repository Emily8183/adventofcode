package main;
import main.day1.day1;
import main.day2.day2;
import main.day3.day3;

public class solution {
    public static void main(String[] args) {

        // day1 day1 = new day1();
        // String content = "main/day1/day1data.txt";
        // day1.day1solution(content);

        // day2 day2 = new day2();        
        // String content = "main/day2/day2extratest.txt";
        // int countResult = day2.countReport(content);
        // System.out.println(countResult);

        day3 day3 = new day3();
        String data = "main/day3/day3data.txt";
        int result = day3.calMultiply(data);
        System.out.println(result);
        
    }
    
}
