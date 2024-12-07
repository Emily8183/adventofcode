//goal: to check if the given arrays are in the right order
//solution: graph + Topological Sorting

package main.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class day5 {

    //step 1: convert the file into graph and indegree 建模和记录入度
    public static void day5(String filePath, HashSet<Integer> set, HashMap<Integer,List<Integer>> graph, HashMap<Integer, Integer> inDegreeMap) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Integer count = 0;

            while ((line = reader.readLine()) != null) {
                String[] pairs = line.split("\\|");
                
                int s = Integer.parseInt(pairs[0].trim());
                int t = Integer.parseInt(pairs[1].trim());

                set.add(s);
                set.add(t);
                 
                count++;

                // when the num is not continuous, hashmap is better than ArrayList<>(); 
                graph.putIfAbsent(s, new ArrayList<>()); //if didn't find s, add s and an empty list
                graph.putIfAbsent(t, new ArrayList<>()); 
                graph.get(s).add(t);

                inDegreeMap.put(t, inDegreeMap.getOrDefault(t, 0) + 1);
                inDegreeMap.putIfAbsent(s, 0); 

            }

            System.out.println("the set size is " + set.size());//49个文件（n)
            System.out.println("There are " + count + " lines"); //1176个入度(m)

        }

        //print out graph
        // System.out.println("printing out the graph");
        // for (Map.Entry<Integer,List<Integer>> entry : graph.entrySet()) {
        //     System.out.println(entry.getKey() + ":" + entry.getValue());
        // }
      
        // //print out inDegreeMap
        // System.out.println("printing out the inDegreeMap");
        // for (Map.Entry<Integer,Integer> entry : inDegreeMap.entrySet()){
        //     System.out.println(entry.getKey() + ":" + entry.getValue());
        // }
    }

    // step2: check each array if its valid
    public boolean isValidArray(int[] arr, HashMap<Integer,List<Integer>> graph, int index) {
        
        if (index == arr.length -1) return true;

        int current = arr[index];

        if (graph.containsKey(current)) {
            List<Integer> validNextNums = graph.get(current);
            for (int i = index+1; i < arr.length; i++) {
                if (!validNextNums.contains(arr[i])) return false;
            }

        } else return false;

        return isValidArray(arr, graph, index+1);

    }

    //step3: loop through each line, find the valid ones and get the middle number
    public int collectArrays(String filePath, HashMap<Integer,List<Integer>> graph) throws IOException {

        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(",");

                // convert from char[] to int[]
                int[] arr = Arrays.stream(parts)
                                  .mapToInt(Integer::parseInt)
                                  .toArray();

                if (isValidArray(arr, graph, 0)) {
                    int middle = arr[arr.length/2];
                    sum += middle;
                }

            }

        return sum;

        }
    }
    
}
