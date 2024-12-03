//goal: to find the smallest num from both of the left and right list, cal the difference, and add up
//solution: bruce force: find the smallest num by using Java method
//to read the file: BufferedReader and FileReader (must use try{}); 
//important: convert from List<Integer> to int[]

package main.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class day1 {
    public void day1solution(String content) {
        //part1

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        try (BufferedReader readData = new BufferedReader(new FileReader(content))){
        String line;

        while ((line = readData.readLine()) != null) {
            String[] split = line.split("\\s+"); //when there are multiple spaces, add "+"

            left.add(Integer.parseInt(split[0]));
            right.add(Integer.parseInt(split[1]));
        }

        // Convert List<Integer> to int[]
        int[] leftArr = left.stream().mapToInt(Integer::intValue).toArray();
        int[] rightArr = right.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(leftArr);
        Arrays.sort(rightArr);

        int totalDiff = 0;

        for (int i = 0; i < leftArr.length; i++) {
            totalDiff += Math.abs(rightArr[i]-leftArr[i]);
        }
 
        System.out.println(totalDiff);

        int totalSum = 0;

        //part2
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < rightArr.length; i++) {
            map.put(rightArr[i], map.getOrDefault(rightArr[i],0)+1);
        }

        for (int i = 0; i < leftArr.length; i++) {
            if (map.containsKey(leftArr[i])) {
                    int count = map.getOrDefault(leftArr[i],0);
                    totalSum += leftArr[i] * count;
                }
        }

        System.out.println(totalSum);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
