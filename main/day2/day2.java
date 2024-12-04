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
import java.util.LinkedList;
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

        LinkedList<Integer> list = new LinkedList<>();

        for (int num : nums) {
            list.add(num);
        }
        
        for (int i = 0; i < list.size(); i++) {
            int removeItem = list.remove(i);

            if (validList(list)) {
                return true;
            } 

            list.add(i,removeItem);
     
        }

        return false;

    }

    //part2: to compare the two adjacent nums in linkedlist
    private boolean validList(LinkedList<Integer> list) {
        int i = 1;

        while (i < list.size()) {
            int difference = Math.abs(list.get(i) - list.get(i-1));

            if ((isIncreasing(list) || isDecreasing(list)) && difference >= 1 && difference <= 3) {
                i++;
            } else {
                return false;
            } 
        }
        return true;
    }

    private boolean isIncreasing(LinkedList<Integer> list) {

        int i = 1;

        while (i < list.size()) {
            if (list.get(i) > list.get(i-1)) {
                i++;
            } else return false;
        }

        return true;
    }

    private boolean isDecreasing(LinkedList<Integer> list) {

        int i = 1;

        while (i < list.size()){
            if (list.get(i) < list.get(i-1)) {
                i++;
            } else return false;
        }

        return true;
    }

    //part1: to compare the two adjacent nums in an array
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
