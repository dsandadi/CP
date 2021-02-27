/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericsstudysession;

/**
 *
 * @author DINESH
 */
public class GenericsStudySession {

    /**
     * @param args the command line arguments
     */
    private class Node<T> {

        T value;

        public Node(T value) {

            this.value = value;
        }
    }

    public <T> void createNode(T value) {

        Node<T> n = new Node(value);
        displayNode(n);

    }
public void displayNode(Node n){
    System.out.println("Node values is :" + n.value);
}
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        GenericsStudySession s = new GenericsStudySession();
        s.createNode(10);
        
        
    }

}
