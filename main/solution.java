package main;
import main.day1.day1;
import main.day2.day2;

public class solution {
    public static void main(String[] args) {

        // day1 day1 = new day1();
        // String content = "main/day1/day1data.txt";

        // day1.day1solution(content);

        day2 day2 = new day2();
        int[] nums = {7,6,4,2,1};

        boolean result = day2.day2solution(nums);

        System.out.println(result);
        
    }
    
}
