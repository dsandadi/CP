/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DINESH
 */
public class Tries {

    Node head;

    public Tries() {
        head = new Node(true, 1);
    }

    class Node {

        HashMap<Character, Node> children;
        boolean isComplete;
        int times;

        public Node(boolean isComplete, int times) {
            children = new HashMap<>();
            this.isComplete = isComplete;
            this.times = times;
        }
    }

    private void addNode(String contact) {
        Node temp = head;
        for (int i = 0; i < contact.length(); i++) {

            //  head.isComplete = false;
            HashMap<Character, Node> curr = temp.children;
            Character nodeCharacter = contact.charAt(i);

            if (!curr.containsKey(nodeCharacter)) {
                temp.isComplete = false;

                Node newNode = new Node(true, 0);

                temp.children.put(nodeCharacter, newNode);

                temp = newNode;
            } else {
                Node currentNode = curr.get(nodeCharacter);
                temp = currentNode;
            }

            temp.times++;

        }
    }

    /**
     * @param args the command line arguments
     */
    private void calculate(String op, String contact) {
        if (op.equals("add")) {
            addNode(contact);
        } else {
            System.out.println(count(contact));
        }

    }
    public void displayTree(Node current)
    { 
       // if(current == null) return;
       
        //else
        //{
           // System.out.println("Left :");
            for(Map.Entry<Character,Node> entry :current.children.entrySet())
            {
                //System.out.println("current NOde :"+entry.getKey());
                printChildren( entry.getValue(),entry.getKey());
                displayTree(entry.getValue());
                
             //for(Node child:current.)
            }
       // }
    }
    private void printChildren (Node current,Character display)
    {
        System.out.printf("\nParent %c 's Children : ",display);
        for(Map.Entry<Character, Node> entry:current.children.entrySet())
        {
            System.out.printf("%c  ", entry.getKey());
        }
    }
            
    private int count(String contact) {
        Node current = head;
        for (int i = 0; i < contact.length(); i++) {
            HashMap<Character, Node> curr = current.children;
            Character cCharacter = contact.charAt(i);
            if (curr.containsKey(cCharacter)) {
                current = curr.get(cCharacter);
            }
            else return 0;
        }
        return current.times;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Number");
        int n = in.nextInt();
        Tries t = new Tries();
        System.out.println("Enter command");
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            t.calculate(op, contact);
            t.displayTree(t.head);
            //System.out.println("Enter the key to search");
            //String word = in.next();
            //t.count(word);
            
        }
    }
}
