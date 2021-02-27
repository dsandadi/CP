
/****
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author DINESH
 */
public class WordNet {

    /**
     * @param args the command line arguments
     */
    private SAP sap;
    // to store all the nouns and the node ids in which these nouns exist.
    private HashMap<String, HashSet<Integer>> graphNames = new HashMap<>();
    // to store all the synonym sets.
    private HashMap<Integer, String> synsets = new HashMap<>();

    public WordNet(String synsets, String hypernyms) {
        In in = new In(synsets);// creating input stream from string.

        // creating wordnetGraph.
        int id = processSynFile(in);
        Digraph wordnetGraph = new Digraph(id);
        in = new In(hypernyms);
        processhyperFile(in, wordnetGraph);
        sap = new SAP(wordnetGraph);

    }

    private void processhyperFile(In in, Digraph wordnetGraph) {
        String line = in.readLine();
        while (line != null) {
            processHyperLine(line, wordnetGraph);
            line = in.readLine();
        }
    }

    private void processHyperLine(String line, Digraph wordnetGraph) {
        String[] hyperIds = line.split(",");
        int synId = Integer.parseInt(hyperIds[0]);
        for (int i = 1; i < hyperIds.length; i++) {
            int hyperId = Integer.parseInt(hyperIds[i]);
            wordnetGraph.addEdge(synId, hyperId);
        }
    }

    private int processSynFile(In in) {
        String line = in.readLine();
        int id = -1;
        while (line != null) {
            id = processLine(line);
            line = in.readLine();
        }
        return id + 1;
    }

    private int processLine(String line) {
        //Scanner sc = new Scanner(line);
        String[] words = line.split(",");
        int synId = Integer.parseInt(words[0]);
        String nouns = words[1];
        String[] sepNouns = nouns.split(" ");
        // loading synid into the graph names.
        for (String curr : sepNouns) {
            if (!graphNames.containsKey(curr))
                graphNames.put(curr, new HashSet<>());
            graphNames.get(curr).add(synId);
        }
        synsets.put(synId, nouns);
        return synId;
    }

    public Iterable<String> nouns() {
        return graphNames.keySet();
    }

    public boolean isNoun(String word) {
        return graphNames.containsKey(word);
    }

    public int distance(String nounA, String nounB) {
        //Yet to implement;
        if (!(isNoun(nounA) && isNoun(nounB))) {
            throw new java.lang.IllegalArgumentException();
        }
        return sap.length(graphNames.get(nounA), graphNames.get(nounB));
    }

    public String sap(String nounA, String nounB) {
        //return hashset in string format.
        //Not Yet implemented.
        if (!(isNoun(nounA) && isNoun(nounB))) {
            throw new java.lang.IllegalArgumentException();
        }
        return synsets.get(sap.ancestor(graphNames.get(nounA), graphNames.get(nounB)));
    }
}
