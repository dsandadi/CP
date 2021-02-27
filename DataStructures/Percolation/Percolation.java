/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author DINESH
 */
public class Percolation {

    private WeightedQuickUnionUF a;
    private WeightedQuickUnionUF b;
    private boolean[][] grid;
    private int top, bottom;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        grid = new boolean[n][n];
        a = new WeightedQuickUnionUF((n * n) + 2);
        b = new WeightedQuickUnionUF((n * n) + 1);
        top = (n * n);
        bottom = (n * n) + 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
    }

    public void open(int row, int col) {
        row = row - 1;
        col = col - 1;
        if ((row < 0) || (row >= grid.length) || (col < 0) || (col >= grid.length)) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        } else {
            if (!isOpen(row + 1, col + 1)) {
                grid[row][col] = true;

                if (row == 0) {
                    a.union(top, (((row * (grid.length)) + col)));
                    b.union(top, (((row * (grid.length)) + col)));
                }

                if ((row == grid.length - 1)) {
                    a.union(bottom, (((row * (grid.length)) + col)));
                }

                if ((row - 1) > -1) {
                    if (isOpen(row, col + 1)) {
                        a.union(((row * (grid.length)) + col), (((row - 1) * (grid.length)) + col));
                        b.union(((row * (grid.length)) + col), (((row - 1) * (grid.length)) + col));
                    }
                }

                if ((row + 1) < (grid.length)) {

                    if (isOpen((row + 2), col + 1)) {
                        a.union(((row * (grid.length)) + col), ((row + 1) * (grid.length)) + col);
                        b.union(((row * (grid.length)) + col), ((row + 1) * (grid.length)) + col);

                    }
                }

                if ((col - 1) > -1) {
                    if (isOpen(row + 1, col)) {
                        a.union(((row * (grid.length)) + (col)), ((row * (grid.length)) + (col - 1)));
                        b.union(((row * (grid.length)) + (col)), ((row * (grid.length)) + (col - 1)));

                    }
                }
                if ((col + 1) < grid.length) {
                    if (isOpen(row + 1, col + 2)) {
                        a.union(((row * (grid.length)) + (col)), ((row * (grid.length)) + (col + 1)));
                        b.union(((row * (grid.length)) + (col)), ((row * (grid.length)) + (col + 1)));

                    }
                }

            }
        }
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
        row = row - 1;
        col = col - 1;
        if ((row < 0) || (row >= grid.length) || (col < 0) || (col >= grid.length)) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        if (!isOpen(row, col)) {
            return false;
        }
        row = row - 1;
        col = col - 1;
        if ((row < 0) || (row >= grid.length) || (col < 0) || (col >= grid.length)) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }

        return (b.connected(top, (((row * grid.length) + col))));
    }

    public boolean percolates() {

        return a.connected(top, bottom);

    }

    public int numberOfOpenSites() {
        int numbOpenSites = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]) {
                    numbOpenSites++;
                }
            }
        }
        return numbOpenSites;
    }
}
