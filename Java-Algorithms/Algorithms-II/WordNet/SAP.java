/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

/**
 * @author DINESH
 */
public class SAP {
    private Digraph netGraph;

    public SAP(Digraph G) {
        netGraph = G;
    }

    private boolean isValidVertex(int vertex) {
        if (vertex < 0 || vertex >= netGraph.V()) {
            return false;
        }
        return true;
    }

    public int length(int v, int w) {
        if (!isValidVertex(v) || !isValidVertex(w)) {
            throw new java.lang.IllegalArgumentException();
        }
        BreadthFirstDirectedPaths b1 = new BreadthFirstDirectedPaths(netGraph, v);
        BreadthFirstDirectedPaths b2 = new BreadthFirstDirectedPaths(netGraph, w);
        int vert = netGraph.V();
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < vert; i++) {
            int d1 = b1.distTo(i);
            int d2 = b2.distTo(i);
            if (d1 != Integer.MAX_VALUE && d2 != Integer.MAX_VALUE) {
                dist = Math.min(d1 + d2, dist);
            }
        }
        return dist == Integer.MAX_VALUE ? -1 : dist;
    }


    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new java.lang.IllegalArgumentException();
        }
        BreadthFirstDirectedPaths b1 = new BreadthFirstDirectedPaths(netGraph, v);
        BreadthFirstDirectedPaths b2 = new BreadthFirstDirectedPaths(netGraph, w);
        int vert = netGraph.V();
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < vert; i++) {
            int d1 = b1.distTo(i);
            int d2 = b2.distTo(i);
            if (d1 != Integer.MAX_VALUE && d2 != Integer.MAX_VALUE) {
                dist = Math.min(d1 + d2, dist);
            }
        }
        return dist;
    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new java.lang.IllegalArgumentException();
        }
        BreadthFirstDirectedPaths b1 = new BreadthFirstDirectedPaths(netGraph, v);
        BreadthFirstDirectedPaths b2 = new BreadthFirstDirectedPaths(netGraph, w);
        int vert = netGraph.V();
        int dist = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int i = 0; i < vert; i++) {
            int d1 = b1.distTo(i);
            int d2 = b2.distTo(i);
            if (d1 != Integer.MAX_VALUE && d2 != Integer.MAX_VALUE) {
                if (d1 + d2 < dist) {
                    dist = d1 + d2;
                    ancestor = i;
                }
            }
        }
        return ancestor;
    }

    public int ancestor(int v, int w) {

        if (!isValidVertex(v) || !isValidVertex(w)) {
            throw new java.lang.IllegalArgumentException();
        }

        BreadthFirstDirectedPaths b1 = new BreadthFirstDirectedPaths(netGraph, v);
        BreadthFirstDirectedPaths b2 = new BreadthFirstDirectedPaths(netGraph, w);
        int vert = netGraph.V();
        int dist = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int i = 0; i < vert; i++) {
            int d1 = b1.distTo(i);
            int d2 = b2.distTo(i);
            if (d1 != Integer.MAX_VALUE && d2 != Integer.MAX_VALUE) {
                if (d1 + d2 < dist) {
                    dist = d1 + d2;
                    ancestor = i;
                }
            }
        }
        return ancestor;
    }
}
