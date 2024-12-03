//goal: boolean + count;
//condition: decrease or increase, at the most 3, return true;
//solution: for loop

package main.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class day2 {

    public int countReport(String content) {
        //part 1

        int count = 0;

        try (BufferedReader readData = new BufferedReader(new FileReader(content))) {
        String line;

        while ((line = readData.readLine()) != null) {
            String[] split = line.split("\\s+");

            int[] nums = new int[split.length];

            for (int i = 0; i < split.length; i++) {
                try {
                nums[i] = Integer.parseInt(split[i]);
                } catch (NumberFormatException e) {
                    System.out.println("invalid format");
                    continue;
                }
            }

            System.out.println(Arrays.toString(nums)); //print to confirm the array data
       
            if (comparison(nums)) count++;

        }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } 

        return count;

    }

    private boolean comparison(int[] nums) { //to compare the two adjacent nums
        int i = 1;

        while (i < nums.length) {
            int difference = Math.abs(nums[i] - nums[i-1]);

            if ((isIncreasing(nums) || isDecreasing(nums)) && difference >= 1 && difference <= 3) {
                i++;
            } else {
                return false;
            } 
        }
        return true;
    }

    private boolean isIncreasing(int[] nums) {

        int i = 1;

        while (i < nums.length) {
            if (nums[i] > nums[i-1]) {
                i++;
            } else return false;
        }

        return true;
    }

    private boolean isDecreasing(int[] nums) {

        int i = 1;

        while (i < nums.length){
            if (nums[i] < nums[i-1]) {
                i++;
            } else return false;
        }

        return true;
    }
    
}
