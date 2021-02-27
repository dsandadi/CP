/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccinterview.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DINESH
 */
public class DupPerm {

    public HashMap<Character, Integer> buildFreqTable(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
            } else {
                map.put(word.charAt(i), 1);
            }

        }
        return map;
    }

    public ArrayList<String> generatePerm(int neededChars, HashMap<Character, Integer> freqTable) {
        ArrayList<String> result = new ArrayList<>();
        if (neededChars == 0) {
            result.add("");
            return result;
        } else {
            for (Map.Entry<Character, Integer> handle : freqTable.entrySet()) {
                Character current = handle.getKey();
                Integer count = handle.getValue();
                if (count > 0) {
                    freqTable.put(current, count - 1);
                    for (String s : generatePerm(neededChars - 1, freqTable)) {
                        result.add(current + s);
                        freqTable.put(current, count);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DupPerm p = new DupPerm();
        String word = "aaabd";
        HashMap<Character, Integer> map = p.buildFreqTable(word);
        for (Map.Entry<Character, Integer> a : map.entrySet()) {
            System.out.println(a.getKey() + " : " + a.getValue());
        }

        System.out.println("================================");
        ArrayList<String> ans = p.generatePerm(word.length(), map);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
