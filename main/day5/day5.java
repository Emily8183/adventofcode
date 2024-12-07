//goal: to check if the given arrays are in the right order
//solution: graph + Topological Sorting

package main.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class day5 {

    //step 2: topological sorting (to make the numbers in order)
    public static void topoSorting (String filePath, HashMap<Integer,List<Integer>> graph, HashMap<Integer, Integer> inDegreeMap) {

        //queue, add the first file with 0 indegree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 49; i++) {
            if (inDegreeMap.get(i) == 0) { //如果入度为0
                queue.add(i); //就把这个节点加到queue
            }
        }

        List<Integer> result = new ArrayList<>();

        //Topological sorting
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);

            for (int file : graph.get(cur)) {
                inDegreeMap.put(file, inDegreeMap.get(file)-1); //不可以直接把inDegreeMap.get(file)--,不知道为什么
                if (inDegreeMap.get(file) == 0) {
                    queue.add(file);
                }
            }
        }

        System.out.println(result);

        //get the sorted array as the result
        // for (int i = 0; i < result.size(); i++) {
        //     System.out.println(result.get(i));
        // }
    }


    //hashmap: key is number, value is index


    //traverse, find each number, go back to the hashmap to compare the index


    //find the correct ones


    //find the middle number, return sum

    //step 1: convert the file into graph and indegree 建模和记录入度
    public static void day5(String filePath, HashSet<Integer> set, HashMap<Integer,List<Integer>> graph, HashMap<Integer, Integer> inDegreeMap) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] pairs = line.split("\\|");
                
                int s = Integer.parseInt(pairs[0].trim());
                int t = Integer.parseInt(pairs[1].trim());

                set.add(s);
                set.add(t);

                System.out.println("the set size is" + set.size()); //49个文件
                

                //when the num is not continuous, hashmap is better than ArrayList<>(); 
                graph.putIfAbsent(s, new ArrayList<>()); //if didn't find s, add s and an empty list
                graph.get(s).add(t); //if found s, grab the value (which is the s' arraylist, add the t. so we will get how many t the s points to.
                
                inDegreeMap.putIfAbsent(s,0);
                inDegreeMap.put(t, inDegreeMap.getOrDefault(t,0) + 1);
            
            }
        
        }

        //print out graph
        System.out.println("printing out the graph");
        for (Map.Entry<Integer,List<Integer>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //print out inDegreeMap
        System.out.println("printing out the inDegreeMap");
        for (Map.Entry<Integer,Integer> entry : inDegreeMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    
}
