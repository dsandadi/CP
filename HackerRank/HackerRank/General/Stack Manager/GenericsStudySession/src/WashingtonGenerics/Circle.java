/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WashingtonGenerics;

/**
 *
 * @author DINESH
 */
public class Circle implements TwoDShape<Circle>{

    @Override
    public void display() {
        System.out.println("This is a circle");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Circle getShape() {
        return this;
    }
    
}
