/**
 * part1:
 * goal: find the exact format of mul(num,num);
 * solution: Regex, matcher.group
 * important: 
 * \\(: Matches the literal opening parenthesis (. The backslash (\) is escaped as \\ in Java strings.
 * \\d+: Matches one or more digits (\d is shorthand for digits, and + means one or more).
 */

package main.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day3 {
    public int part1() {

        String input = transferData();

        int multiply = 0;

        String reqPattern = "mul\\((\\d+),(\\d+)\\)"; 

        Pattern pattern = Pattern.compile(reqPattern);

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) { //matches() checks if the entire string matches the patter
            String firstNum = matcher.group(1);
            String secondNum = matcher.group(2);

            System.out.println("Matched: mul(" + firstNum + "," + secondNum + ")");

            multiply += (Integer.parseInt(firstNum) * Integer.parseInt(secondNum));
        }

        return multiply;

    } 


    private String transferData() {
        String content = "main/day3/day3data.txt";

        StringBuilder fullText = new StringBuilder();

        try (BufferedReader readData = new BufferedReader(new FileReader(content))) {

            String line;
            
            //to convert the txt.file to string
            while ((line = readData.readLine()) != null) {
    
                //to fix the texts spanning different lines
                fullText.append(line).append(" "); 
            }

        } catch (IOException e) {
            System.err.println();
        }

        
        return fullText.toString();


    }

}
    

