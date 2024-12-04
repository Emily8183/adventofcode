/**
 * part1:
 * goal: find the exact format of mul(num,num);
 * solution: Regex, matcher.group
 */



package main.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day3 {
    public int calMultiply(String content) {

        int multiply = 0;

        try (BufferedReader readData = new BufferedReader(new FileReader(content))) {

        String line;

        String reqPattern = "mul\\((\\d+),(\\d+)\\)";

        StringBuilder fullText = new StringBuilder();
        
        Pattern pattern = Pattern.compile(reqPattern);

        while ((line = readData.readLine()) != null) {

            fullText.append(line).append(" "); 
        }

        Matcher matcher = pattern.matcher(fullText.toString());

        while (matcher.find()) { //matches() checks if the entire string matches the patter
            String firstNum = matcher.group(1);
            String secondNum = matcher.group(2);

            System.out.println("Matched: mul(" + firstNum + "," + secondNum + ")");

            multiply += (Integer.parseInt(firstNum) * Integer.parseInt(secondNum));
        }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return multiply;

    }


}
    

