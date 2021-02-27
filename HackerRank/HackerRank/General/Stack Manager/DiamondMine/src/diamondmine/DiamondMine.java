/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamondmine;

/**
 *
 * @author DINESH
 */
public class DiamondMine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private int createAnswer(int[][] values, int row,int col,int[][] grid){
        if(row == grid.length - 1 && col == grid[0].length - 1) 
                    return grid[row][col];
        
        
        return 0;
    }
}
