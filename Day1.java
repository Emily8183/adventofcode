//goal: to find the smallest num from both of the left and right list, cal the difference, and add up
//solution: bruce force: find the smallest num with Java method
//to read the file: BufferedReader and FileReader (must use try{}); try-with-resources 
//important: convert from List<Integer> to int[]

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) {
        String data = "day1data.txt";

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        try (BufferedReader readData = new BufferedReader(new FileReader(data))){
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

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}