/**
 * part1: 
 * goal: boolean + count;
 * condition: decrease or increase, at the most 3, return true;
 * solution: for loop
 * 
 * part2:
 * goal: remove 1, double check;
 * solution: stack + for loop
 */

package main.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class day2 {

    public int countReport(String content) {
       
        // int countPart1 = 0;
        int countPart2 = 0;

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
       
            // if (comparison(nums)) countPart1++;
            if (remove(nums)) countPart2++;

        }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } 

        return countPart2;

    }

    //Part 2: check again by removing maximum 1 element
    private boolean remove(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        stack.add(nums[0]);

        int times = 0;

        for (int i = 1; i < nums.length; i++) {
            boolean increasing = false;
    
            int difference = Math.abs(nums[i] - nums[i-1]);

            if (nums[1] > nums[0]) {
                increasing = true;
            }
            
            stack.add(nums[i]);

            if (nums[i] <= nums[i-1] && increasing && !stack.isEmpty()) {
                stack.pop();
                times++;
            }
            
            if (nums[i] >= nums[i-1] && !increasing && !stack.isEmpty()) {
                stack.pop();
                times++;
            }

            if (difference > 3 && !stack.isEmpty()) {
                stack.pop();
                times++;
            }
        }

        return times <= 1;

    }

    //part1: to compare the two adjacent nums
    private boolean comparison(int[] nums) {
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
