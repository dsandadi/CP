/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccinterview.DynamicProgramming;

import java.util.ArrayList;

/**
 *
 * @author DINESH
 */
public class Parens {

    public static ArrayList<String> generateParen(int rightRem, int leftRem) {

        ArrayList<String> result = new ArrayList<>();

        if (leftRem < 0 || rightRem < leftRem) {
            return result;
        }

        if ((rightRem == leftRem) && rightRem == 0) {
            result.add("");
            return result;
        } else {
            //System.out.println("right :"+ rightRem);
            //System.out.println("right :"+ rightRem);

            for (String s : generateParen(rightRem, leftRem - 1)) {
                result.add("(" + s);
            }

            for (String s : generateParen(rightRem - 1, leftRem)) {
                result.add(")" + s);
            }
            return result;
        }
    }
    public static void main(String[] args){
        
        ArrayList<String> ans = new ArrayList<>();
        
        ans = generateParen(4,4);

        for(String s: ans)
            System.out.println(s);
        
    }
    
    
}
