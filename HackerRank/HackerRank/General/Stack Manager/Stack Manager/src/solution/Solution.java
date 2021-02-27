package solution;

import java.util.List;
import java.util.Stack;


public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] answer = new int[n];
        Stack<Integer> processStack = new Stack<>();
        int prevTime = 0;
        
        for(int i =0;i<logs.size();i++)
        {
         String[] words = logs.get(i).split(":");
        int timeStamp = Integer.parseInt(words[2]);
        String status = words[1];
        int Id = Integer.parseInt(words[0]);
        
        if(status.equals("start")){
            
            if(!processStack.empty())
                answer[processStack.peek()] += timeStamp - prevTime; 
                
            prevTime = timeStamp;
            processStack.push(Id);
        }        
    
            if(status.equals("end")){
                answer[processStack.pop()] += timeStamp - prevTime + 1;
                prevTime = timeStamp + 1;
            }
        }
 return answer;
    
}}