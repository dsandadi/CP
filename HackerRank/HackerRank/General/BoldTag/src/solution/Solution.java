package solution;

import java.util.HashMap;

/**
 *
 * @author DINESH
 */
public class Solution {

    Node head;

    public Solution() {
        head = new Node();

    }

    public String addBoldTag(String s, String[] dict) {
        makeMap(dict);
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Node current = head;
            Character find = s.charAt(i);
            if (current.neigbors.containsKey(find)) {
                b.append("<b>");
                while (current.neigbors.containsKey(find)) {
                    current = current.neigbors.get(find);
                    b.append(find);
                    i++;
                    if (i >= s.length()) {
                        break;
                    }
                    find = s.charAt(i);

                }
                i--;
                b.append("</b>");
                //if(i < )
              //  b.append(s.charAt(i));
            } else {
                b.append(find);
            }
        }
        return b.toString();
    }

    private void makeMap(String[] dict) {
        // Node current =head;
        for (String word : dict) {
            Node current = head;

            for (int i = 0; i < word.length(); i++) {
                Character key = word.charAt(i);
                if (current.neigbors.containsKey(key)) {
                    current = current.neigbors.get(key);
                }
                else{
                Node newNode = new Node();
                //newNode.display = word.charAt(i);
                current.neigbors.put(word.charAt(i), newNode);
                //System.out.
                current = newNode;
                }
            }
        }
    }

    class Node {

        HashMap<Character, Node> neigbors = new HashMap<>();
        //Character display;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] k = {"aaa","aab","bc","aaabbcc"
        };
        System.out.println(s.addBoldTag("aaabbcc", k));

    }
}
