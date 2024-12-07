//goal: to check if the given arrays are in the right order
//solution: graph + Topological Sorting

package main.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day5 {

    //build the graph and indegree 建模和记录入度


    // HashMap<Integer, Integer> inDegreeMap = new HashMap<>();






    //queue, add the first file with 0 indegree


    //Topological sorting

    

    //get the sorted array as the result


    //hashmap: key is number, value is index


    //traverse, find each number, go back to the hashmap to compare the index


    //find the correct ones


    //find the middle number, return sum

    public static void day5(String filePath, HashMap<Integer,List<Integer>> graph, HashMap<Integer, Integer> inDegreeMap) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] pairs = line.split("\\|");
                
                int s = Integer.parseInt(pairs[0].trim());
                int t = Integer.parseInt(pairs[1].trim());

                //when the num is not continuous, hashmap is better than ArrayList<>(); 
                graph.putIfAbsent(s, new ArrayList<>()); //if didn't find s, add s and an empty list
                graph.get(s).add(t); //if found s, grab the value (which is the s' arraylist, add the t. so we will get how many t the s points to.
                
                inDegreeMap.putIfAbsent(s,0);
                inDegreeMap.put(t, inDegreeMap.getOrDefault(t,0) + 1);
            
            }
        
        }

        //print out graph
        for (Map.Entry<Integer,List<Integer>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //print out inDegreeMap
        // for (Map.Entry<Integer,Integer> entry : inDegreeMap.entrySet()){
        //     System.out.println(entry.getKey() + ":" + entry.getValue());
        // }

        
    }
    
}
