package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import main.day1.day1;
import main.day2.day2;
import main.day3.day3;
import main.day4.day4_part1;
import main.day4.day4_part2;
import main.day5.day5;


public class solution {
    public static void main(String[] args) throws IOException {

        // day1 day1 = new day1();
        // String content = "main/day1/day1data.txt";
        // day1.day1solution(content);

        // day2 day2 = new day2();        
        // String content = "main/day2/day2extratest.txt";
        // int countResult = day2.countReport(content);
        // System.out.println(countResult);

        // day3 day3 = new day3();
        // String content = "main/day3/part2.txt";
        
        // int result1 = day3.part1(content);
        
        // int result2 = day3.part2(content);
        // System.out.println(result2); 

        // day4_part1 day4_part1 = new day4_part1();
        // day4_part2 day4_part2 = new day4_part2();
        // String board = "main/day4/day4data.txt";
        // // int part1Result = day4_part1.countFindings(0, 0, 0, "XMAS", board);
        // int part2Result = day4_part2.countMas(0,0,0,"MAS",board);
        // System.out.println(part2Result);

        day5 day5 = new day5();
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegreeMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        String file = "main/day5/day5pairs.txt";
        day5.day5(file, set, graph, inDegreeMap);
        day5.topoSorting(file, graph, inDegreeMap);

        



        
    }
    
}
