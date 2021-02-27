/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccinterview.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DINESH
 */
public class PermsD {

    public ArrayList<String> getAllPerms(String word) {
        ArrayList<String> answer = new ArrayList<>();

        if (word.length() == 0) {
            answer.add("");
            return answer;
        } else {
            for (int i = 0; i < word.length(); i++) {

                ArrayList<String> perms = getAllPerms(word.substring(0, i) + word.substring(i + 1));
                //answer.addAll(perms);
                for (String current : perms) {
                    answer.add(word.charAt(i) + current);
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        PermsD p = new PermsD();
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        ArrayList<String> words = p.getAllPerms(word);

        System.out.println("permutations are :");
        for (String w : words) {
            System.out.println(w);
        }
    }

}
