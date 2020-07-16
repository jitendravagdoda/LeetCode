package Interval;
import java.util.*;
//  Can you write a Java Program to count the number of words in a string using HashMap

public class Solution {
    public static void main(String[] args) {
      String s ="Can you write a Java Program HashMap to count the number of words in a string using HashMap";
      Map<String, Integer> map =new HashMap();

      for(String temp:s.split(" ")){
          map.put(temp, map.getOrDefault(temp, 0)+1);
      }
        System.out.println(map.toString());
    }
}
