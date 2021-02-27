/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccinterview.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author DINESH
 */
public class DP {

    private class Point {

        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    private boolean makePath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {

        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);
        boolean isAtOrigin = (row == 0 && col == 0);

        if (isAtOrigin || makePath(maze, row, col - 1, path, failedPoints)
                || makePath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }
        return false;
    }

    private ArrayList<Point> findPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        HashSet<Point> failedPoints = new HashSet<>();
        ArrayList<Point> path = new ArrayList<>();
        if (makePath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;

    }

    
    
    
    public static void main(String[] args) {
        // if valid maze entry is true else false.
        
        
    }

}
