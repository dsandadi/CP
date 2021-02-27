/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccinterview;

/**
 *
 * @author DINESH
 */
public class CompressString {

    String compressString(String a) {
        char prev = a.charAt(0);
        int count = 1;
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < a.length(); i++) {
            char current = a.charAt(i);
            if (current == prev) {
                count++;
            } else {
                answer.append(prev);
                answer.append(Integer.toString(count));
                count = 1;
            }
            prev = current;
        }
        answer.append(prev);
        answer.append(Integer.toString(count));
        return answer.toString();
    }

    private void rotateMatrix(int[][] matrix) {
        int N = matrix.length;
        for (int layer = 0; layer < N / 2; layer++) {
            int first = layer;
            int last = N - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                
                int top = matrix[first][i];
                //left->top
                matrix[first][i] = matrix[last-offset][first];
                //bottom -> left 
                matrix[last-offset][first] = matrix[last][last-offset];
                //right->bottom
                matrix[last][last-offset] = matrix[i][last];
               //top->bottome
                matrix[i][last] = top;       
            }

            
        }}
        /**
         * @param args the command line arguments
         */
    public static void main(String[] args) {
        // TODO code application logic here

        CompressString c = new CompressString();
        //System.out.println(c.compressString("aaabbcccddd"));
        int[][] matrix = new int[3][3];
        int counter = 1;
        for(int row = 0;row<3;row++){
            for(int col = 0;col<3;col++){
                matrix[row][col] = counter ++;
        }
    }
        c.rotateMatrix(matrix);
        for(int row = 0;row<3;row++){
            for(int col = 0;col<3;col++){
               System.out.print(matrix[row][col]+" "); 
        }
            System.out.println();
    }
}
}