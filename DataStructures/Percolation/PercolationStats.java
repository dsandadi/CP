/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DINESH
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] fractionSum;

    public PercolationStats(int n, int trials) {
        if (n < 0) {
            throw new java.lang.IllegalArgumentException("Invalid input");
        }
        if (trials <= 0) {
            throw new java.lang.IllegalArgumentException("Invalid Input");
        }
        fractionSum = new double[trials];
        while (trials != 0) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int random1 = StdRandom.uniform(1, n + 1);
                int random2 = StdRandom.uniform(1, n + 1);
                if (!p.isOpen(random1, random2)) {
                    p.open(random1, random2);
                }

            }
            fractionSum[trials - 1] = ((float) p.numberOfOpenSites()) / (n * n);
            trials--;
        }
    }

    public double mean() {
        return StdStats.mean(fractionSum);
    }

    public double stddev() {
        return StdStats.stddev(fractionSum);
    }

    public double confidenceLo() {
        double lower = mean() - ((stddev() * 1.96) / Math.sqrt(fractionSum.length));
        return lower;
    }

    public double confidenceHi() {
        double higher = mean() + ((stddev() * 1.96) / Math.sqrt(fractionSum.length));
        return higher;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats perc = new PercolationStats(n, t);
        System.out.println("mean                   =" + perc.mean());
        System.out.println("stddev                 =" + perc.stddev());
        System.out.println("95% confidence interval= [" + perc.confidenceLo() + ", " + perc.confidenceHi() + "]");
    }
}
