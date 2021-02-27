/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.princeton.cs.algs4.StdIn;

/**
 *
 * @author DINESH
 */
public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> test = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        while (StdIn.hasNextLine()) {
            String word = StdIn.readString();
            test.enqueue(word);
        }

        while (k != 0) {
            System.out.println(test.dequeue());
            k--;
        }
    }
}
