/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WashingtonGenerics;

import java.util.ArrayList;

/**
 *
 * @author DINESH
 */
public class Driver {
    
    public static < T extends Shape<T> > void display( ArrayList<T> shapes){
    
    
    }
    
    public static void main(String[] args){
        ArrayList<Circle> circles = new ArrayList<>();
        Driver d = new Driver();
       // d.display();
        circles.add(new Circle());
        circles.add(new Circle());
    }
}
