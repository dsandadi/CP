import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        HashMap<Character,Integer> data1 = new HashMap<Character,Integer>();
        StringBuilder test = new StringBuilder();
        int answer = 0;
        for(int i =0 ;i < first.length(); i++ )
        {  
            if(!data1.containsKey(first.charAt(i)))
            data1.put(first.charAt(i),1);
            else
            data1.put(first.charAt(i),data1.get(first.charAt(i))+1);
        }
       for(int i = 0;i<second.length();i++)
        {
        if(!data1.containsKey(second.charAt(i)))
            answer++;
         else
             {
             data1.put(second.charAt(i),data1.get(second.charAt(i))-1);
         }   
       }
       for(Integer i: data1.values())
           {
           answer = answer+ Math.abs(i);
            }
      
        return answer;
    }
    
    
  
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
