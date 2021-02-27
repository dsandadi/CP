/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author DINESH
 */
public class Outcast {

    private WordNet wordnet;

    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    public String outcast(String[] nouns) {
        int maxDist = Integer.MIN_VALUE;
        String castNoun = "";
        for (int i = 0; i < nouns.length; i++) {
            int totalDist = 0;
            for (int j = 0; j < nouns.length; j++) {
                if (i != j)
                    totalDist += wordnet.distance(nouns[i], nouns[j]);
            }
            //  System.out.println("Total Distance for noun "+ i +", "+ nouns[i]+" "+ totalDist);
            if (totalDist > maxDist) {
                maxDist = totalDist;
                castNoun = nouns[i];
            }
        }
        return castNoun;
    }

    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}
